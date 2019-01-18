package com.lboeri.boeriapi.controller;

import com.lboeri.boeriapi.dao.singleton.ApiConfigSgMapper;
import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BoeriApiController {

    public static String APINAME = "APINAME";
    @Autowired
    BoeriApiMapper boeriApiMapper;

    @Autowired
    ApiConfigSgMapper apiConfigSgMapper;
    @RequestMapping("/api/{api_name}")
    public Map<String,Object> boeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        List<LinkedHashMap> list =  boeriApiMapper.selectByEntity(params);
        reMap.put("obj",list);
        return reMap;
    }
}
