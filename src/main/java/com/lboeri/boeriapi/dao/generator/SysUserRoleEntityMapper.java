package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.SysUserRoleEntity;

public interface SysUserRoleEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRoleEntity record);

    int insertSelective(SysUserRoleEntity record);

    SysUserRoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRoleEntity record);

    int updateByPrimaryKey(SysUserRoleEntity record);
}