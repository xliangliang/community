package com.liangliang.community.search.service;

import com.liangliang.community.dto.RegisterParam;
import com.liangliang.community.entity.User;
import com.liangliang.community.model.UserAdmin;

public interface UserService {
    Long addUser(User user);
    User getUser(String fullname);
    int modifyLoginTime(User user);
    User userLogin(String username, String password);
    UserAdmin register(RegisterParam registerParam);
}
