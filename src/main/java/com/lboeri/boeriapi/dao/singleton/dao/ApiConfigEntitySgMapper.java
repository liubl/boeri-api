package com.lboeri.boeriapi.dao.singleton.dao;

import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;

import java.util.List;

public interface ApiConfigEntitySgMapper {
    int deleteByEntity(ApiConfigEntity record);

    List<ApiConfigEntity> selectByEntity(ApiConfigEntity record);

}