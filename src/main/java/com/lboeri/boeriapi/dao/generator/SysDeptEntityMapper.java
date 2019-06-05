package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.SysDeptEntity;

public interface SysDeptEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDeptEntity record);

    int insertSelective(SysDeptEntity record);

    SysDeptEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDeptEntity record);

    int updateByPrimaryKey(SysDeptEntity record);
}