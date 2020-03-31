package com.liangliang.community.dto;

/**
 * @author Liangliang
 * @date 2020/3/30
 * @desc
 */
public class LoginParam {
    private String username;
    private String password;

    public LoginParam() {
    }

    public LoginParam(String username, String password) {
        this.username = username;
        this.password = password;
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
}
