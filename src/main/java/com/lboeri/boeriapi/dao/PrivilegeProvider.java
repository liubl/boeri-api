package com.lboeri.boeriapi.dao;

import com.lboeri.boeriapi.controller.BoeriApiController;
import com.lboeri.boeriapi.dao.generator.entity.ApiConfig;
import com.lboeri.boeriapi.dao.singleton.ApiConfigSgMapper;
import com.lboeri.boeriapi.util.Replacement;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public  class PrivilegeProvider {
    @Autowired
    ApiConfigSgMapper apiConfigSgMapper;

    public static final String DSNAME = "DSNAME";

    public static final String EXCSQL = "EXCSQL";

    public static PrivilegeProvider privilegeProvider;

    @PostConstruct
    public void init() {
        privilegeProvider = this;
        privilegeProvider.apiConfigSgMapper = this.apiConfigSgMapper;
    }

    public String querySql(Map<String,Object> param){

        String sql = buildSql("select", param);
        return sql;
    }

    public String pageSql(Map<String,Object> param){

        String sql = buildPageSql("select", param);
        return sql;
    }

    public String modSql(Map<String,Object> param){

        String sql = buildSql("update", param);
        return sql;
    }

    public String addSql(Map<String,Object> param){

        String sql = buildSql("insert", param);
        return sql;
    }

    public String delSql(Map<String,Object> param){

        String sql = buildSql("delete", param);
        return sql;
    }

    private String buildSql(String type, Map<String,Object> param){

        String sql = "";
        ApiConfig entity = new ApiConfig();

        DynamicDataSourceContextHolder.setDataSourceType(DynamicDataSourceContextHolder.DEFAULT);
        entity.setApiName(param.get(BoeriApiController.APINAME)+"");
        List<ApiConfig> config = privilegeProvider.apiConfigSgMapper.selectByEntity(entity);
        if (config != null && config.size() > 0) {
            ApiConfig rsConfig = config.get(0);
            DynamicDataSourceContextHolder.setDataSourceType(rsConfig.getDsName());
            try {
                return Replacement.buildSql(type,rsConfig.getExcSql(), param);
            } catch (JDOMException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

    private String buildPageSql(String type, Map<String,Object> param){

        String sql = "";
        if (param.get(DSNAME) != null && param.get(EXCSQL) != null) {
            DynamicDataSourceContextHolder.setDataSourceType((String) param.get(DSNAME));
            try {
                return Replacement.buildSql(type, (String) param.get(EXCSQL), param);
            } catch (JDOMException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }
}
