package com.lboeri.boeriapi.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MybatisConfig {


    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicRoutingDataSource dataSource() {

        /**
         * 创建PreparedStatement对象
         */
        PreparedStatement preparedStatement = null;
        /**
         * 创建结果集对象
         */
        ResultSet resultSet = null;

        DynamicRoutingDataSource dataSourceRouter = new DynamicRoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());

        try {

            //默认数据源
            dataSourceRouter.setDefaultTargetDataSource(dataSource);
            targetDataSources.put(DynamicDataSourceContextHolder.DEFAULT, dataSource);

            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT  ");
            sql.append("   DS_CN_NAME as \"DS_CN_NAME\",  ");
            sql.append("   DS_NAME as \"DS_NAME\",  ");
            sql.append("   DB_TYPE as \"DB_TYPE\",  ");
            sql.append("   DS_TYPE as \"DS_TYPE\",  ");
            sql.append("   DRIVER_CLASS_NAME as \"DRIVER_CLASS_NAME\",  ");
            sql.append("   DS_URL as \"DS_URL\",  ");
            sql.append("   USER_NAME as \"USER_NAME\",  ");
            sql.append("   USER_PASSWORD as \"USER_PASSWORD\",  ");
            sql.append("   INI_SIZE as \"INI_SIZE\",  ");
            sql.append("   MIN_IDLE as \"MIN_IDLE\",  ");
            sql.append("   MAX_IDLE as \"MAX_IDLE\",  ");
            sql.append("   MAX_ACTIVE as \"MAX_ACTIVE\",  ");
            sql.append("   MAX_WAIT as \"MAX_WAIT\",  ");
            sql.append("   REMOVE_ABANDONED as \"REMOVE_ABANDONED\",  ");
            sql.append("   REMOVE_ABANDONED_TIMEOUT as \"REMOVE_ABANDONED_TIMEOUT\",  ");
            sql.append("   TIME_BWT_EVN_MILLIS as \"TIME_BWT_EVN_MILLIS\",  ");
            sql.append("   TEST_WHILE_IDLE as \"TEST_WHILE_IDLE\",  ");
            sql.append("   VALIDATION_QUERY as \"VALIDATION_QUERY\",  ");
            sql.append("   DS_STATUS as \"DS_STATUS\",  ");
            sql.append("   CREATE_TIME as \"CREATE_TIME\",  ");
            sql.append("   CREATE_USER as \"CREATE_USER\"  ");
            sql.append(" FROM e_ext_datasource  ");
            sql.append("WHERE DS_STATUS = '1'  ");
            preparedStatement = dataSource.getConnection().prepareStatement(sql.toString());
            // 执行
            resultSet = preparedStatement.executeQuery();

            // 将ResultSet的结果保存到Map中
            while (resultSet.next()) {
                DruidDataSource dataSourceclust = new DruidDataSource();
                dataSourceclust.setUrl(resultSet.getString("DS_URL"));
                dataSourceclust.setDriverClassName(resultSet.getString("DRIVER_CLASS_NAME"));
                dataSourceclust.setUsername(resultSet.getString("USER_NAME"));
                dataSourceclust.setPassword(resultSet.getString("USER_PASSWORD"));
                dataSourceclust.setDbType(resultSet.getString("DB_TYPE"));
                if (resultSet.getString("MAX_ACTIVE") != null) {
                    dataSourceclust.setMaxActive(resultSet.getInt("MAX_ACTIVE"));
                }
                if (resultSet.getString("MIN_IDLE") != null) {
                    dataSourceclust.setMinIdle(resultSet.getInt("MIN_IDLE"));
                }
                if (resultSet.getString("MAX_WAIT") != null) {
                    dataSourceclust.setMaxWait(resultSet.getInt("MAX_WAIT"));
                }
                if (resultSet.getString("INI_SIZE") != null) {
                    dataSourceclust.setInitialSize(resultSet.getInt("INI_SIZE"));
                }
                if(resultSet.getString("TEST_WHILE_IDLE") != null ){
                    if(resultSet.getBoolean("TEST_WHILE_IDLE")){
                        dataSourceclust.setValidationQuery(resultSet.getString("VALIDATION_QUERY"));
                    }
                    dataSourceclust.setTestWhileIdle(resultSet.getBoolean("TEST_WHILE_IDLE"));
                }
                targetDataSources.put(resultSet.getString("DS_NAME"), dataSourceclust);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //制定数据源
        dataSourceRouter.setTargetDataSources(targetDataSources);
        return dataSourceRouter;

    }

    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //必须将动态数据源添加到 sqlSessionFactoryBean
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicRoutingDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }


}