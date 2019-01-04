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

    @Bean(name = "dataSource")
    @Primary
    public DataSourceRouter dataSource() {

        /**
         * 创建PreparedStatement对象
         */
        PreparedStatement preparedStatement = null;
        /**
         * 创建结果集对象
         */
        ResultSet resultSet = null;

        DataSourceRouter dataSourceRouter = new DataSourceRouter();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        //默认数据源
        dataSourceRouter.setDefaultTargetDataSource(dataSource);
        targetDataSources.put("defualt", dataSource);

        try {
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT id   as \"ID\" , ");
            sql.append("        dsid   as \"DSID\" , ");
            sql.append("        dbtype   as \"DBTYPE\" , ");
            sql.append("        driverclassname   as \"DRIVERCLASSNAME\" , ");
            sql.append("        url   as \"URL\" , ");
            sql.append("        username   as \"USERNAME\" , ");
            sql.append("        password   as \"PASSWORD\" , ");
            sql.append("        initialsize   as \"INITIALSIZE\" , ");
            sql.append("        maxactive   as \"MAXACTIVE\" , ");
            sql.append("        minidle   as \"MINIDLE\" , ");
            sql.append("        maxwait   as \"MAXWAIT\" , ");
            sql.append("        removeabandoned   as \"REMOVEABANDONED\" , ");
            sql.append("        removeabandonedtimeout   as \"REMOVEABANDONEDTIMEOUT\" , ");
            sql.append("        timebetweenevictionrunsmillis   as \"TIMEBETWEENEVICTIONRUNSMILLIS\" , ");
            sql.append("        minevictableidletimemillis   as \"MINEVICTABLEIDLETIMEMILLIS\" , ");
            sql.append("        validationquery   as \"VALIDATIONQUERY\" , ");
            sql.append("        testwhileidle   as \"TESTWHILEIDLE\" , ");
            sql.append("        testonborrow   as \"TESTONBORROW\" , ");
            sql.append("        testonreturn   as \"TESTONRETURN\" , ");
            sql.append("        poolpreparedstatements   as \"POOLPREPAREDSTATEMENTS\" , ");
            sql.append("        maxpoolprestatperconnsize   as \"MAXPOOLPRESTATPERCONNSIZE\" , ");
            sql.append("        filters   as \"FILTERS\" , ");
            sql.append("        hooktime   as \"HOOKTIME\" , ");
            sql.append("        hooks   as \"HOOKS\" , ");
            sql.append("        create_by   as \"CREATE_BY\" , ");
            sql.append("        create_date   as \"CREATE_DATE\" , ");
            sql.append("        update_by   as \"UPDATE_BY\" , ");
            sql.append("        update_date   as \"UPDATE_DATE\" , ");
            sql.append("        remarks   as \"REMARKS\" , ");
            sql.append("        del_flag   as \"DEL_FLAG\"   ");
            sql.append(" FROM TBL_API_SOURCE  ");
            sql.append("WHERE del_flag = '0'  ");
            preparedStatement = dataSource.getConnection().prepareStatement(sql.toString());
            // 执行
            resultSet = preparedStatement.executeQuery();


            // 将ResultSet的结果保存到Map中
            while (resultSet.next()) {
                DruidDataSource dataSourceclust = new DruidDataSource();
                dataSourceclust.setUrl(resultSet.getString("URL"));
                dataSourceclust.setDriverClassName(resultSet.getString("DRIVERCLASSNAME"));
                dataSourceclust.setUsername(resultSet.getString("USERNAME"));
                dataSourceclust.setPassword(resultSet.getString("PASSWORD"));
                targetDataSources.put(resultSet.getString("ID"), dataSourceclust);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //制定数据源
        dataSourceRouter.setTargetDataSources(targetDataSources);
        return dataSourceRouter;

    }

    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理器
     */
     @Bean
     public DataSourceTransactionManager transactionManager(DataSourceRouter dataSource) throws Exception {
                 return new DataSourceTransactionManager(dataSource);
     }
}