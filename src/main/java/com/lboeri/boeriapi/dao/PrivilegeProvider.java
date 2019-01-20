package com.lboeri.boeriapi.dao;

import com.lboeri.boeriapi.controller.BoeriApiController;
import com.lboeri.boeriapi.dao.generator.entity.ApiConfig;
import com.lboeri.boeriapi.dao.singleton.ApiConfigSgMapper;
import com.lboeri.boeriapi.util.Replacement;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@Configurable
public  class PrivilegeProvider {
    @Autowired
    ApiConfigSgMapper apiConfigSgMapper;

    public static PrivilegeProvider privilegeProvider;

    @PostConstruct
    public void init() {
        privilegeProvider = this;
        privilegeProvider.apiConfigSgMapper = this.apiConfigSgMapper;
    }
    public String querySql(Map<String,Object> param){

        String sql = "";

        ApiConfig entity = new ApiConfig();

        DatabaseContextHolder.setDataSourceType(DatabaseContextHolder.DEFAULT);
        entity.setApiName(param.get(BoeriApiController.APINAME)+"");
        List<ApiConfig> config = privilegeProvider.apiConfigSgMapper.selectByEntity(entity);
        if (config != null && config.size() > 0) {
            ApiConfig rsConfig = config.get(0);
            DatabaseContextHolder.setDataSourceType(rsConfig.getDsName());
            try {
                return Replacement.buildSql(rsConfig.getExcSql(), param);
            } catch (JDOMException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }
}
