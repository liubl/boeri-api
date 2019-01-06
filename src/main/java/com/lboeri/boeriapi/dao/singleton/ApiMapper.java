package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.SimpleSelectLangDriver;
import com.lboeri.boeriapi.dao.common.entity.ApiSourceEntity;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface  ApiMapper {

    @Select("${querySql}")
    List<Map> selectByEntity(Map<String,Object> pram);
}