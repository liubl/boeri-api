package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.DatabaseContextHolder;
import com.lboeri.boeriapi.dao.generator.entity.ApiConfig;
import com.lboeri.boeriapi.dao.singleton.ApiConfigSgMapper;
import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import com.lboeri.boeriapi.util.Replacement;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
