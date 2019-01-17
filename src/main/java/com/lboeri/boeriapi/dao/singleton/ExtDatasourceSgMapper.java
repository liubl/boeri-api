package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;

import java.util.List;

public interface ExtDatasourceSgMapper {
    int deleteByEntity(ExtDatasource record);

    List<ExtDatasource> selectByEntity(ExtDatasource record);

    int updateByEntity(ExtDatasource record);
}