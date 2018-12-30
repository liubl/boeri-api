package com.lboeri.boeriapi.controller;

import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;
import com.lboeri.boeriapi.dao.singleton.dao.ApiConfigEntitySgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ApiController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    ApiConfigEntitySgMapper apiConfigEntitySgMapper;

    @RequestMapping("/greeting")
    public Map greeting(@RequestParam(value="name", defaultValue="World") String name) {
        ApiConfigEntity entity = new ApiConfigEntity();
        Map map = new HashMap();
        entity.setApiname("getUserCityInfo");
        List list = apiConfigEntitySgMapper.selectByEntity(entity);
        map.put("obj",list);
        return map;
    }
}
