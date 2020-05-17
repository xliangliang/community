package com.liangliang.community.dao;

import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.AdminParam;
import com.liangliang.community.model.CAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AdminDao {

    /**
     * 登录
     *
     * @return token
     */
    CAdmin login(@Param("loginParam") LoginParam loginParam);

    /**
     * 注册
     */
    int insert(@Param("registerParam") AdminParam registerParam);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     */
    CAdmin select(@Param("username") String username);

    /**
     * 获取用户信息
     *
     * @param adminId
     */
    CAdmin selectById(@Param("adminId") Long adminId);

    /**
     * 更新登录时间
     */
    void updateLoginTime(@Param("adminId") Long adminId, @Param("date") Date date);

    /**
     * 更新头像
     */
    int updateIcon(@Param("adminId") Long adminId, @Param("iconUrl") String iconUrl);
}
