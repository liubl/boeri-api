package com.lboeri.boeriapi.dao.common.dao;

import com.lboeri.boeriapi.dao.common.entity.ApiSourceEntity;

public interface ApiSourceEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(ApiSourceEntity record);

    int insertSelective(ApiSourceEntity record);

    ApiSourceEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ApiSourceEntity record);

    int updateByPrimaryKey(ApiSourceEntity record);
}