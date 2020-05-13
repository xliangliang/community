package com.liangliang.community.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * created by Liangliang on 2020/5/12
 */
@Setter
@Getter
public class CommentParam {
    @ApiModelProperty(value = "问题id", required = true)
    @NotEmpty
    private Long questionId;
    @ApiModelProperty(value = "回复父类id")
    private Integer parentId;
    @ApiModelProperty(value = "回复内容")
    @NotEmpty
    private String comment;
}
