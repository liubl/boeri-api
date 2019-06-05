package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.SysRoleEntity;

public interface SysRoleEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleEntity record);

    int insertSelective(SysRoleEntity record);

    SysRoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleEntity record);

    int updateByPrimaryKey(SysRoleEntity record);
}