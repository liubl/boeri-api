package com.lboeri.boeriapi.service;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lboeri.boeriapi.dao.DynamicRoutingDataSource;
import com.lboeri.boeriapi.dao.generator.ExtDatasourceMapper;
import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;
import com.lboeri.boeriapi.dao.singleton.ApiConfigSgMapper;
import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import com.lboeri.boeriapi.dao.singleton.ExtDatasourceSgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BoeriServiceImpl implements BoeriService {

    @Autowired
    ExtDatasourceMapper extDatasourceMapper;

    @Autowired
    private DynamicRoutingDataSource dynamicDataSource;

    @Override
    public Map<String,Object> addDataSource(ExtDatasource datasource) {
        Map<String,Object> rsMap = new HashMap<String,Object>();
        System.out.println(datasource.getDsCnName());
        ExtDatasource extDatasource = extDatasourceMapper.selectByPrimaryKey(datasource.getDsName());
        if(extDatasource != null && extDatasource.getDsUrl().length() > 0){
            int i = extDatasourceMapper.insertSelective(datasource);
            if(i > 0){
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
                map.put(dynamicDataSource.DSNAME, datasource.getDsName());
                dynamicDataSource.addDataSource(map);
            }
        }
        return rsMap;
    }

}
