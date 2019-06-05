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

    @Autowired
    BoeriService boeriServiceImpl;

    @Autowired
    private DynamicRoutingDataSource dynamicDataSource;

    /**
     * 添加数据源示例
     *
     * @return
     */
    @PostMapping("/add-data-source")
    public Map<String ,Object> addDataSource(@Validated @RequestBody ExtDatasource datasource) {

        Map<String ,Object> result = boeriServiceImpl.addDataSource(datasource);
        return result;
    }
}
