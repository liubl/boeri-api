package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.DatabaseContextHolder;
import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;
import com.lboeri.boeriapi.dao.singleton.ApiConfigEntitySgMapper;
import com.lboeri.boeriapi.dao.singleton.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoeriServiceImpl implements BoeriService {

    @Autowired
    ApiConfigEntitySgMapper configEntitySgMapper;

    @Autowired
    ApiMapper apiMapper;

    @Override
    public Map<String,Object> findApiConfig(String id) {
        Map<String,Object> rsMap = new HashMap<String,Object>();
        ApiConfigEntity entity = new ApiConfigEntity();
        entity.setApiname(id);
        DatabaseContextHolder.setDataSourceType("default");
        List<ApiConfigEntity> config = configEntitySgMapper.selectByEntity(entity);
        if (config != null && config.size() > 0){
            ApiConfigEntity rsConfig = config.get(0);
            DatabaseContextHolder.setDataSourceType(rsConfig.getDsid().toString());
            Map<String,Object> pram = new HashMap<>();
            pram.put("querySql",rsConfig.getQuerySql());
            pram.put("parent_code","240");
            rsMap.put("obj",apiMapper.selectByEntity(pram));
        }

        return rsMap;
    }
}
