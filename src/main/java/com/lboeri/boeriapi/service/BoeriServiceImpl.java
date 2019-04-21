package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.singleton.ApiConfigSgMapper;
import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BoeriServiceImpl implements BoeriService {

    @Autowired
    ApiConfigSgMapper configEntitySgMapper;

    @Autowired
    BoeriApiMapper apiMapper;

    @Override
    public Map<String,Object> findApiConfig(String id) {
        Map<String,Object> rsMap = new HashMap<String,Object>();

        return rsMap;
    }

}
