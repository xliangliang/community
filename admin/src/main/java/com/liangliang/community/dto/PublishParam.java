package com.liangliang.community.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Liangliang
 * @date 2020/4/23
 * @desc
 */
@Setter
@Getter
public class PublishParam {
    @ApiModelProperty(value = "问题标题", required = true)
    private String title;
    @NotNull
    @ApiModelProperty(value = "问题补充", required = true)
    private String supplement;
    @ApiModelProperty(value = "标签", required = true)
    @NotNull
    private String label;
}
