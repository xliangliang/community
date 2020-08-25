package com.liangliang.community.service;

import com.liangliang.community.dto.AdminDetailInfoDto;
import com.liangliang.community.dto.AdminPageParam;
import com.liangliang.community.dto.AdminParam;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminService {
    /**
     * 注册
     */
    @Transactional
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
     * 获取用户详细信息
     */
    AdminDetailInfoDto getAdminDetailInfo(String username);

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

    /**
     * 更新用户头像
     */
    int updateIcon(String username, String iconUrl);

    /**
     * 分页获取用户
     */
    List<CAdmin> list(AdminPageParam adminPageParam, Integer pageNum, Integer pageSize);

    /**
     * 获取所用用户
     */
    List<CAdmin> list();
}
