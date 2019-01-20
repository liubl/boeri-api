package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.PrivilegeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoeriApiMapper {

    @SelectProvider(type = PrivilegeProvider.class, method = "querySql")
    List<LinkedHashMap> selectByEntity(Map<String,Object> param);
}