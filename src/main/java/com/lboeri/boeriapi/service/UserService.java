package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.generator.entity.ExtDatasource;
import com.lboeri.boeriapi.record.User;

import java.util.Map;

public interface UserService {

    String login(String username, String password);

    User findUserById(String username);
}
