package com.lboeri.boeriapi.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MybatisConfig {


    @Autowired
    private DataSourceProperties dataSourceProperties;



//    @Bean(name = "dataSource")
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(dataSourceProperties.getUrl());
//        System.out.println(dataSourceProperties.getUrl());
//        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
//        dataSource.setUsername(dataSourceProperties.getUsername());
//        dataSource.setPassword(dataSourceProperties.getPassword());
//
//        return dataSource;
//
//    }

    @Bean(name = "dataSource")
    public DataSourceRouter dataSource() {

        /**
         * 创建PreparedStatement对象
         */
        PreparedStatement preparedStatement = null;
        /**
         * 创建CallableStatement对象
         */
        CallableStatement callableStatement = null;
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
            preparedStatement = dataSource.getConnection().prepareStatement(sql.toString());
            // 执行
            resultSet = preparedStatement.executeQuery();

            // 创建ResultSetMetaData对象
            ResultSetMetaData rsmd = resultSet.getMetaData();

            // 获得结果集列数
            int columnCount = rsmd.getColumnCount();

            // 创建List
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

            // 将ResultSet的结果保存到List中
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(rsmd.getColumnLabel(i), resultSet.getObject(i));
                    System.out.println(rsmd.getColumnLabel(i));
                    DruidDataSource dataSourceclust = new DruidDataSource();
                    dataSourceclust.setUrl(dataSourceProperties.getUrl());
                    dataSourceclust.setDriverClassName(dataSourceProperties.getDriverClassName());
                    dataSourceclust.setUsername(dataSourceProperties.getUsername());
                    dataSourceclust.setPassword(dataSourceProperties.getPassword());
                    targetDataSources.put("defualt", dataSourceclust);
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSourceRouter.setTargetDataSources(targetDataSources);

        return dataSourceRouter;

    }

    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }
}