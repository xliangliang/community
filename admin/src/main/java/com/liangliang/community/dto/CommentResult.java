package com.liangliang.community.dto;

import com.liangliang.community.model.CComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * created by Liangliang on 2020/5/13
 */
@Setter
@Getter
public class CommentResult extends CComment{
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户头像")
    private String icon;
}
