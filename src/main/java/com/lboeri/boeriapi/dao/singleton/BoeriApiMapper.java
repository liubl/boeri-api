package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.PrivilegeProvider;
import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoeriApiMapper {

    @SelectProvider(type = PrivilegeProvider.class, method = "querySql")
    List<LinkedHashMap> selectByEntity(Map<String,Object> param);

    @UpdateProvider(type = PrivilegeProvider.class, method = "modSql")
    Integer updateByEntity(Map<String,Object> param);

    @InsertProvider(type = PrivilegeProvider.class, method = "addSql")
    Integer insertByEntity(Map<String,Object> param);

    @DeleteProvider(type = PrivilegeProvider.class, method = "delSql")
    Integer deleteByEntity(Map<String,Object> param);
}