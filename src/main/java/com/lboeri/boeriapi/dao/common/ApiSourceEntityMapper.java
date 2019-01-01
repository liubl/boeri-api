package com.lboeri.boeriapi.dao.common;

import com.lboeri.boeriapi.dao.common.entity.ApiSourceEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiSourceEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(ApiSourceEntity record);

    int insertSelective(ApiSourceEntity record);

    ApiSourceEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ApiSourceEntity record);

    int updateByPrimaryKey(ApiSourceEntity record);
}