package com.liangliang.community.service;

import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.model.CAdmin;

public interface AdminService {
    /**
     * 注册
     */
    int register(RegisterParam registerParam);

    /**
     * 登录
     * @return token
     */
    CAdmin login(LoginParam loginParam);
}
