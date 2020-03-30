package com.liangliang.community.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Liangliang
 * @date 2020/3/30
 * @desc
 */
public class LoginParam {
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;

    public LoginParam() {
    }

    public LoginParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
