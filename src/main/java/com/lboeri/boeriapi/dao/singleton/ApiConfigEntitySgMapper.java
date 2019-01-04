package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;
import io.netty.handler.codec.serialization.ObjectDecoder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApiConfigEntitySgMapper {

    int deleteByEntity(ApiConfigEntity record);

    List<ApiConfigEntity> selectByEntity(ApiConfigEntity record);

    @Select("SELECT * FROM sys_dept")
    List<Map<String,Object>> selectCity();

}