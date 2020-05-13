package com.liangliang.community.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * created by Liangliang on 2020/5/12
 */
@Setter
@Getter
public class AdminDetailInfoDto {
    @ApiModelProperty(value = "用户id")
    private Long adminId;
    @ApiModelProperty(value = "用户头像")
    private String icon;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "问题总数")
    private Integer questionTotal;
    @ApiModelProperty(value = "总关注人数")
    private Integer followTotal;
    @ApiModelProperty(value = "粉丝总数")
    private Integer fansTotal;
}
