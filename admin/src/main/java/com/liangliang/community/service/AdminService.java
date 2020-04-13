package com.liangliang.community.service;

import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

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
    String login(String username, String password);

    /**
     * 测试自定义注解
     */
    void testAspect();

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取后台管理员
     */
    CAdmin getAdminByUsername(String username);

    /**
     * 获取指定用户的可访问资源
     */
    List<CResource> getResourceList(Long adminId);
}
