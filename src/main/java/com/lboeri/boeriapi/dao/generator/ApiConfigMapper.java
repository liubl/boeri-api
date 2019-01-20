package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.ApiConfig;

public interface ApiConfigMapper {
    int deleteByPrimaryKey(String apiId);

    int insert(ApiConfig record);

    int insertSelective(ApiConfig record);

    ApiConfig selectByPrimaryKey(String apiId);

    int updateByPrimaryKeySelective(ApiConfig record);

    int updateByPrimaryKeyWithBLOBs(ApiConfig record);

    int updateByPrimaryKey(ApiConfig record);
}