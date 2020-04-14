package com.liangliang.community.service;

import com.liangliang.community.dto.AdminParam;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AdminService {
    /**
     * 注册
     */
    CAdmin register(AdminParam adminParam);

    /**
     * 登录
     *
     * @return token
     */
    String login(String username, String password);

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

    /**
     * 刷新token
     */
    String refreshToken(String token);
}
