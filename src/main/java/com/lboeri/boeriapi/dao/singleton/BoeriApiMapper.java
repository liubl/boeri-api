package com.lboeri.boeriapi.dao.singleton;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoeriApiMapper {

    @Select("${querySql}")
    List<Map> selectByEntity(Map<String,Object> param);
}