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
        ApiConfig entity = new ApiConfig();
        entity.setApiname(id);
        DatabaseContextHolder.setDataSourceType(DatabaseContextHolder.DEFAULT);
        List<ApiConfig> config = configEntitySgMapper.selectByEntity(entity);
        if (config != null && config.size() > 0){
            ApiConfig rsConfig = config.get(0);
            DatabaseContextHolder.setDataSourceType(rsConfig.getDsid().toString());
            Map<String,Object> pram = new HashMap<>();
            pram.put("parent_code","240");
            try {
                pram.put("querySql", Replacement.buildSql(rsConfig.getQuerySql(),pram));
            } catch (JDOMException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            rsMap.put("obj",apiMapper.selectByEntity(pram));
        }

        return rsMap;
    }

}
