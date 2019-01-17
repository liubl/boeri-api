package com.lboeri.boeriapi.controller;

import com.lboeri.boeriapi.dao.singleton.ApiConfigSgMapper;
import com.lboeri.boeriapi.service.BoeriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BoeriApiController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    ApiConfigSgMapper apiConfigEntitySgMapper;

    @Autowired
    BoeriService boeriServiceImp;
    @RequestMapping("/api")
    public Map boeriApi(@RequestParam(value="brname", defaultValue="getUserCityInfo") String brname) {

//        ApiConfigEntity entity = new ApiConfigEntity();
//        Map map = new HashMap();
//        entity.setApiname("getUserCityInfo");
//        //DatabaseContextHolder.setDataSourceType("289facb6f21546e287a369ebc2e958be");
//        List list = apiConfigEntitySgMapper.selectByEntity(entity);
//        map.put("obj",list);
        return boeriServiceImp.findApiConfig(brname);
    }
}
