package com.lboeri.boeriapi.controller;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lboeri.boeriapi.dao.DynamicRoutingDataSource;
import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;
import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import com.lboeri.boeriapi.service.BoeriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/config")
public class BoeriApiConfigController {

    public static String APINAME = "APINAME";
    @Autowired
    BoeriService boeriServiceImpl;

    @Autowired
    private DynamicRoutingDataSource dynamicDataSource;

    /**
     * 添加数据源示例
     *
     * @return
     */
    @RequestMapping("/add-data-source")
    public Map<String ,Object> addDataSource(@Validated @RequestBody ExtDatasource datasource) {

        Map<String ,Object> result = boeriServiceImpl.addDataSource(datasource);
        return result;
//        // 构建 DataSource 属性,
//        Map<String, String> map = new HashMap<>();
//        map.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME,
//                datasource.getDriverClassName());
//        map.put(DruidDataSourceFactory.PROP_URL,
//                datasource.getDsUrl());
//        map.put(DruidDataSourceFactory.PROP_USERNAME,
//                datasource.getUserName());
//        map.put(DruidDataSourceFactory.PROP_PASSWORD,
//                datasource.getUserPassword());
//        //其他属性
//        map.put(DruidDataSourceFactory.PROP_MAXACTIVE,
//                datasource.getMaxActive());
//        map.put(DruidDataSourceFactory.PROP_INITIALSIZE,
//                datasource.getIniSize());
//        map.put(DruidDataSourceFactory.PROP_MAXIDLE,
//                datasource.getMaxIdle());
//        map.put(DruidDataSourceFactory.PROP_MINIDLE,
//                datasource.getMinIdle());
//        map.put(DruidDataSourceFactory.PROP_MAXWAIT,
//                datasource.getMaxWait());
//        map.put(DruidDataSourceFactory.PROP_REMOVEABANDONEDTIMEOUT,
//                datasource.getRemoveAbandonedTimeout());
//        map.put(DruidDataSourceFactory.PROP_REMOVEABANDONED,
//                datasource.getRemoveAbandoned());
//        map.put(DruidDataSourceFactory.PROP_VALIDATIONQUERY,
//                datasource.getValidationQuery());
//        map.put(DruidDataSourceFactory.PROP_TESTWHILEIDLE,
//                datasource.getTestWhileIdle());
//        map.put(DruidDataSourceFactory.PROP_TIMEBETWEENEVICTIONRUNSMILLIS,
//                datasource.getTimeBwtEvnMillis());
//        map.put(dynamicDataSource.DSNAME, datasource.getDsName());
//        return dynamicDataSource.addDataSource(map);
    }
}
