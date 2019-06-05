package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.SysUserEntity;

public interface SysUserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserEntity record);

    int insertSelective(SysUserEntity record);

    SysUserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserEntity record);

    int updateByPrimaryKey(SysUserEntity record);
}