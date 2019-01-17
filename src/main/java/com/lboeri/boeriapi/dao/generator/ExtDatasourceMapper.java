package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;

public interface ExtDatasourceMapper {
    int deleteByPrimaryKey(String dsName);

    int insert(ExtDatasource record);

    int insertSelective(ExtDatasource record);

    ExtDatasource selectByPrimaryKey(String dsName);

    int updateByPrimaryKeySelective(ExtDatasource record);

    int updateByPrimaryKey(ExtDatasource record);
}