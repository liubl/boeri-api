package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiConfigEntitySgMapper {

    int deleteByEntity(ApiConfigEntity record);

    List<ApiConfigEntity> selectByEntity(ApiConfigEntity record);

}