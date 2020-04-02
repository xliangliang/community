package com.liangliang.community.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Liangliang
 * @date 2020/3/30
 * @desc
 */
@Getter
@Setter
public class RegisterParam {

    private String username;
    private String password;
    private Date createTime;
}
