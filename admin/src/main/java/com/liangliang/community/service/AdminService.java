package com.liangliang.community.service;

import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.model.CAdmin;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminService {
    /**
     * 注册
     */
    int register(RegisterParam registerParam);

    /**
     * 登录
     *
     * @return token
     */
    CAdmin login(LoginParam loginParam);

    /**
     * 测试自定义注解
     */
    void testAspect();

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);
}
