package com.lboeri.boeriapi.dao.common.dao;

import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiConfigEntityMapper{
    int deleteByPrimaryKey(String id);

    int insert(ApiConfigEntity record);

    int insertSelective(ApiConfigEntity record);

    ApiConfigEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ApiConfigEntity record);

    int updateByPrimaryKeyWithBLOBs(ApiConfigEntity record);

    int updateByPrimaryKey(ApiConfigEntity record);
}