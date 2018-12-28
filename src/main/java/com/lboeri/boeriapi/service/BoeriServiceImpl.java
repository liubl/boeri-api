package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.common.dao.ApiConfigEntityMapper;
import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;
import com.lboeri.boeriapi.dao.singleton.dao.ApiConfigEntitySgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoeriServiceImpl implements BoeriService {

    @Autowired
    ApiConfigEntitySgMapper configEntitySgMapper;

    @Override
    public ApiConfigEntity findApiConfig(String id) {
        ApiConfigEntity config = configEntitySgMapper.selectByPrimaryKey(id);
        return config;
    }
}
