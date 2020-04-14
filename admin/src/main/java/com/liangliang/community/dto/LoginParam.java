package com.liangliang.community.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author Liangliang
 * @date 2020/3/30
 * @desc
 */
@Getter
@Setter
public class LoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotNull(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "用户名", required = true)
    @NotNull(message = "密码不能为空")
    private String password;
}
