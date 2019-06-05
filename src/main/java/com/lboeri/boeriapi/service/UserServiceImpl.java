package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.generator.entity.SysUserEntity;
import com.lboeri.boeriapi.dao.singleton.SysUserEntitySgMapper;
import com.lboeri.boeriapi.record.User;
import com.lboeri.boeriapi.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserEntitySgMapper sysUserEntitySgMapper;

    @Override
    public String login(String username, String password) {
        SysUserEntity entity = new SysUserEntity();
        entity.setUserCode(username);
        entity.setUserPassword(password);
        List<SysUserEntity> list = sysUserEntitySgMapper.selectByEntity(entity);
        if (list.isEmpty() || list.size() == 0) {
            return "";
        }else{
            User user = new User();
            user.setUsername(list.get(0).getUserCode());
            user.setPassword(list.get(0).getUserPassword());
            return JwtUtils.createToken(user);
        }
    }

    @Override
    public User findUserById(String username) {
        SysUserEntity entity = sysUserEntitySgMapper.selectByPrimaryKey(username);
        User user = new User();
        user.setUsername(entity.getUserCode());
        user.setPassword(entity.getUserPassword());
        user.setName(entity.getUserName());
        return user;
    }
}
