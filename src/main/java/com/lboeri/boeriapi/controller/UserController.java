package com.lboeri.boeriapi.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lboeri.boeriapi.annotation.UserLoginToken;
import com.lboeri.boeriapi.dao.singleton.BoeriApiMapper;
import com.lboeri.boeriapi.exception.CustomException;
import com.lboeri.boeriapi.record.User;
import com.lboeri.boeriapi.service.BoeriService;
import com.lboeri.boeriapi.service.UserService;
import com.lboeri.boeriapi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userServiceImpl;

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        if (user == null || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return Result.error(401, "请输入用户名和密码");
        }
        String tokens = userServiceImpl.login(user.getUsername(), user.getPassword());
        if (tokens.isEmpty()) {
            return Result.error(401, "用户名或密码错误");
        }
        reMap.put("token", tokens);
        return Result.ok(reMap);
    }

    @UserLoginToken
    @GetMapping(value = "/info")
    public Map<String, Object> info(String token) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        if (token == null || token.isEmpty()) {
            throw new CustomException(50008, "无token，请重新登录");
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        User user = userServiceImpl.findUserById(userId);
        if (user == null) {
            throw new CustomException(401, "用户不存在，请重新登录");
        }
        try {
            // 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new CustomException(50014, "token过期或失效");
        } catch (UnsupportedEncodingException e) {
            throw new CustomException(500, e.getMessage());
        }
        reMap.put("name",user.getName());
        reMap.put("avatar","https://img2.hackhome.com/img2019/4/29/17/102351365.jpg");
        return Result.ok(reMap);
    }
}
