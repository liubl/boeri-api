package com.lboeri.boeriapi.controller;

import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BoeriApiController {

    public static String APINAME = "APINAME";
    @Autowired
    BoeriApiMapper boeriApiMapper;

    @RequestMapping(value="/{api_name}" ,method = RequestMethod.GET)
    public Map<String,Object> boeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        List<LinkedHashMap> list =  boeriApiMapper.selectByEntity(params);
        reMap.put("obj",list);
        return reMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value="/{api_name}" ,method = RequestMethod.PUT)
    public Map<String,Object> modBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.updateByEntity(params);
        reMap.put("obj",i);
        return reMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value="/{api_name}" ,method = RequestMethod.POST)
    public Map<String,Object> addBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.insertByEntity(params);
        reMap.put("obj",i);
        return reMap;
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value="/{api_name}" ,method = RequestMethod.DELETE)
    public Map<String,Object> delBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.deleteByEntity(params);
        reMap.put("obj",i);
        return reMap;
    }
}
