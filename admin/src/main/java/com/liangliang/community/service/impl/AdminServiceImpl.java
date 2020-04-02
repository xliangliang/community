package com.liangliang.community.service.impl;

import com.liangliang.community.dao.AdminDao;
import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Liangliang
 * @date 2020/4/2
 * @desc
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminDao adminDao;

    @Override
    public int register(RegisterParam registerParam) {
        CAdmin user = adminDao.select(registerParam.getUsername());
        if (user != null) {
            return -1;
        }
        return adminDao.insert(registerParam);
    }

    @Override
    public CAdmin login(LoginParam loginParam) {
        CAdmin user = adminDao.login(loginParam);
        if (user != null) {
            adminDao.updateLoginTime(user.getId(), new Date());
        }
        return user;
    }
}
