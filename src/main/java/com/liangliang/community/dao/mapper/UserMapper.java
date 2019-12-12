package com.liangliang.community.dao.mapper;

import com.liangliang.community.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Long insertUser(@Param("user") User user);
    User getUser(@Param("fullname") String fullname);
    int updateLastLoginTime(@Param("user") User user);
}
