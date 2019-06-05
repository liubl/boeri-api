package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;
import sun.awt.image.ImageWatched;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface BoeriService {
    Map<String,Object> addDataSource(ExtDatasource datasource);

    Map<String,Object> pageQuery(Map<String,Object> param);
}
