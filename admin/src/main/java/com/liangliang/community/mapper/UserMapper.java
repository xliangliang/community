package com.liangliang.community.mapper;

import com.liangliang.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * @param user
     * @return
     */
    Long insertUser(@Param("user") User user);

    /**
     * @param fullname
     * @return
     */
    User getUser(@Param("fullname") String fullname);

    /**
     * @param user
     * @return
     */
    int updateLastLoginTime(@Param("user") User user);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    User userLogin(@Param("username") String username, @Param("password") String password);
}
