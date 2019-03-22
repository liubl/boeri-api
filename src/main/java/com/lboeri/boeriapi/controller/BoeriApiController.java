package com.lboeri.boeriapi.controller;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lboeri.boeriapi.dao.DynamicRoutingDataSource;
import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;
import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BoeriApiController {

    public static String APINAME = "APINAME";
    @Autowired
    BoeriApiMapper boeriApiMapper;

    @RequestMapping(value="/{api_name}" ,method = RequestMethod.GET)
    public Map<String,Object> boeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        List<LinkedHashMap> list =  boeriApiMapper.selectByEntity(params);
        reMap.put("obj",list);
        return reMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value="/{api_name}" ,method = RequestMethod.PUT)
    public Map<String,Object> modBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.updateByEntity(params);
        reMap.put("obj",i);
        return reMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value="/{api_name}" ,method = RequestMethod.POST)
    public Map<String,Object> addBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.insertByEntity(params);
        reMap.put("obj",i);
        return reMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value="/{api_name}" ,method = RequestMethod.DELETE)
    public Map<String,Object> delBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.deleteByEntity(params);
        reMap.put("obj",i);
        return reMap;
    }

    @Autowired
    private DynamicRoutingDataSource dynamicDataSource;

    /**
     * 添加数据源示例
     *
     * @return
     */
    @GetMapping("/add_data_source")
    public Object addDataSource(@RequestParam ExtDatasource datasource) {
        // 构建 DataSource 属性,
        Map<String, String> map = new HashMap<>();
        map.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME,
                datasource.getDriverClassName());
        map.put(DruidDataSourceFactory.PROP_URL,
                datasource.getDsUrl());
        map.put(DruidDataSourceFactory.PROP_USERNAME,
                datasource.getUserName());
        map.put(DruidDataSourceFactory.PROP_PASSWORD,
                datasource.getUserPassword());
        //其他属性
        map.put(DruidDataSourceFactory.PROP_MAXACTIVE,
                datasource.getMaxActive());
        map.put(DruidDataSourceFactory.PROP_INITIALSIZE,
                datasource.getIniSize());
        map.put(DruidDataSourceFactory.PROP_MAXIDLE,
                datasource.getMaxIdle());
        map.put(DruidDataSourceFactory.PROP_MINIDLE,
                datasource.getMinIdle());
        map.put(DruidDataSourceFactory.PROP_MAXWAIT,
                datasource.getMaxWait());
        map.put(DruidDataSourceFactory.PROP_REMOVEABANDONEDTIMEOUT,
                datasource.getRemoveAbandonedTimeout());
        map.put(DruidDataSourceFactory.PROP_REMOVEABANDONED,
                datasource.getRemoveAbandoned());
        map.put(DruidDataSourceFactory.PROP_VALIDATIONQUERY,
                datasource.getValidationQuery());
        map.put(DruidDataSourceFactory.PROP_TESTWHILEIDLE,
                datasource.getTestWhileIdle());
        map.put(DruidDataSourceFactory.PROP_TIMEBETWEENEVICTIONRUNSMILLIS,
                datasource.getTimeBwtEvnMillis());
        map.put("database", datasource.getDsName());
        return dynamicDataSource.addDataSource(map);
    }
}
