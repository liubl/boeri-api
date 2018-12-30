package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;
import com.lboeri.boeriapi.dao.singleton.dao.ApiConfigEntitySgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoeriServiceImpl implements BoeriService {

    @Autowired
    ApiConfigEntitySgMapper configEntitySgMapper;

    @Override
    public List<ApiConfigEntity> findApiConfig(String id) {
        List<ApiConfigEntity> config = configEntitySgMapper.selectByEntity(null);
        return config;
    }
}
