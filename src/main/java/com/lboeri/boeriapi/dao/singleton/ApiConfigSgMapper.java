package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.generator.entity.ApiConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiConfigSgMapper {

    int deleteByEntity(ApiConfig record);

    List<ApiConfig> selectByEntity(ApiConfig record);

}