package com.liangliang.community.service;

import com.liangliang.community.entity.User;

public interface UserService {
    Long addUser(User user);
    User getUser(String fullname);
    int modifyLoginTime(User user);
    User userLogin(String username, String password);
}
