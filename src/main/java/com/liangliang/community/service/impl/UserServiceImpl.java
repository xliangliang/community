package com.liangliang.community.service.impl;

import com.liangliang.community.dao.mapper.UserMapper;
import com.liangliang.community.entity.User;
import com.liangliang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Long addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUser(String fullname) {
        User user = userMapper.getUser(fullname);
        return user;
    }

    @Override
    public int modifyLoginTime(User user) {
        return userMapper.updateLastLoginTime(user);
    }
}
