package com.liangliang.community.service;

import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.entity.User;
import com.liangliang.community.model.UserAdmin;

public interface AdminService {
    /**
     * 注册
     */
    User register(RegisterParam registerParam);

    /**
     * 登录
     * @return token
     */
    String login(LoginParam loginParam);
}
