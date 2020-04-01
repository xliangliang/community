package com.liangliang.community.service.impl;

import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.entity.User;
import com.liangliang.community.mapper.AdminMapper;
import com.liangliang.community.model.UserRegisterParam;
import com.liangliang.community.service.AdminService;
import com.liangliang.community.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements AdminService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public User register(RegisterParam registerParam) {
        logger.info(registerParam.getUsername());
        logger.info(registerParam.getPassword());
        String token = Md5Utils.md5(registerParam.getUsername());
        int count = adminMapper.register(new UserRegisterParam(registerParam.getUsername(), registerParam.getPassword(), new Date(), token));
        if (count != 1) {
            return null;
        }
        User user = adminMapper.select(registerParam.getUsername());
        return user;

    }

    @Override
    public String login(LoginParam loginParam) {
        return adminMapper.login(loginParam);
    }
}
