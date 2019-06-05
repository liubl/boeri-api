package com.lboeri.boeriapi.controller;

import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import com.lboeri.boeriapi.service.BoeriService;
import com.lboeri.boeriapi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BoeriApiController {

    public static String APINAME = "APINAME";
    @Autowired
    BoeriApiMapper boeriApiMapper;
    @Autowired
    BoeriService boeriServiceImpl;

    @GetMapping(value="/page/{api_name}")
    public Map<String,Object> pageBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        List<LinkedHashMap> list =  new ArrayList<>();
        if(params.get("pageNum") != null && params.get("pageSize") != null){
            reMap =  boeriServiceImpl.pageQuery(params);
        }
        return Result.ok(reMap);
    }

    @GetMapping(value="/query/{api_name}")
    public Map<String,Object> queryBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        List<LinkedHashMap> list =  boeriApiMapper.selectByEntity(params);
        return Result.ok(list);
    }

    @Transactional(rollbackFor = Exception.class)
    @PutMapping(value="/{api_name}")
    public Map<String,Object> modBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.updateByEntity(params);
        return Result.ok(i);
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value="/{api_name}")
    public Map<String,Object> addBoeriApi(@RequestParam Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.insertByEntity(params);
        return Result.ok(i);
    }

    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping(value="/{api_name}")
    public Map<String,Object> delBoeriApi(@RequestParam(required = true) Map<String, Object> params, @PathVariable("api_name") String apiName) {
        Map<String,Object> reMap = new HashMap<String,Object>();
        params.put(APINAME,apiName);
        Integer i =  boeriApiMapper.deleteByEntity(params);
        return Result.ok(i);
    }

}
