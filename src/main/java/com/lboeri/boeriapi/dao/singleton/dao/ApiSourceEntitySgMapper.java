package com.lboeri.boeriapi.dao.singleton.dao;

import com.lboeri.boeriapi.dao.common.entity.ApiSourceEntity;

import java.util.List;

public interface ApiSourceEntitySgMapper {
    int deleteByEntity(ApiSourceEntity record);

    List<ApiSourceEntity> selectByEntity(ApiSourceEntity record);
}