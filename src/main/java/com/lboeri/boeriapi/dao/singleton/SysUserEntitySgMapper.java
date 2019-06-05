package com.lboeri.boeriapi.dao.singleton;

import com.lboeri.boeriapi.dao.generator.entity.SysUserEntity;

import java.util.List;

public interface SysUserEntitySgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserEntity record);

    int insertSelective(SysUserEntity record);

    SysUserEntity selectByPrimaryKey(String id);

    List<SysUserEntity> selectByEntity(SysUserEntity entity);

    int updateByPrimaryKeySelective(SysUserEntity record);

    int updateByPrimaryKey(SysUserEntity record);
}