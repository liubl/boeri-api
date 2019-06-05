package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.SysRoleFuncEntity;

public interface SysRoleFuncEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleFuncEntity record);

    int insertSelective(SysRoleFuncEntity record);

    SysRoleFuncEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleFuncEntity record);

    int updateByPrimaryKey(SysRoleFuncEntity record);
}