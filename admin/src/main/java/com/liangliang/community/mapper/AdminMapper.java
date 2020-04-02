package com.liangliang.community.mapper;

import com.liangliang.community.dto.LoginParam;
import com.liangliang.community.entity.User;
import com.liangliang.community.model.UserRegisterParam;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    /**
     * 登录
     *
     * @return token
     */
    String login(@Param("loginParam") LoginParam loginParam);

    /**
     * 注册
     */
    Integer register(@Param("registerParam") UserRegisterParam registerParam);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     */
    User select(@Param("username") String username);
}
