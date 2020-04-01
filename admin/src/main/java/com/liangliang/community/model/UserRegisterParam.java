package com.liangliang.community.model;

import java.io.Serializable;
import java.util.Date;

public class UserRegisterParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Date createTime;
    private String token;

    public UserRegisterParam() {
    }

    public UserRegisterParam(String username, String password, Date createTime, String token) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
