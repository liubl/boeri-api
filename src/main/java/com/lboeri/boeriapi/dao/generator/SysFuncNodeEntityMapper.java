package com.lboeri.boeriapi.dao.generator;

import com.lboeri.boeriapi.dao.generator.entity.SysFuncNodeEntity;

public interface SysFuncNodeEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFuncNodeEntity record);

    int insertSelective(SysFuncNodeEntity record);

    SysFuncNodeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFuncNodeEntity record);

    int updateByPrimaryKey(SysFuncNodeEntity record);
}