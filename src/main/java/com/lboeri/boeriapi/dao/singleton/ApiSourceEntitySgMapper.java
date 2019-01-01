package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.common.entity.ApiSourceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiSourceEntitySgMapper {
    int deleteByEntity(ApiSourceEntity record);

    List<ApiSourceEntity> selectByEntity(ApiSourceEntity record);
}