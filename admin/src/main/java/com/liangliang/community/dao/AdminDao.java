package com.liangliang.community.dao;

import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.mapper.CAdminMapper;
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
    int insert(@Param("registerParam") RegisterParam registerParam);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     */
    CAdmin select(@Param("username") String username);

    /**
     * 获取用户信息
     *
     * @param id
     */
    CAdmin selectById(@Param("id") Long id);

    /**
     * 更新登录时间
     */
    void updateLoginTime(Long id, Date date);
}
