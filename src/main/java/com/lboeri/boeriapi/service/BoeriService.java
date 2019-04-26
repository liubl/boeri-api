package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;

import java.util.Map;

public interface BoeriService {
    Map<String,Object> addDataSource(ExtDatasource datasource);
}
