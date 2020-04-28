package com.liangliang.community.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Liangliang
 * @date 2020/4/24
 * @desc
 */
@Setter
@Getter
public class NewestDto {

    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "问题补充")
    private String supplement;
    @ApiModelProperty(value = "标签")
    private String label;
    @ApiModelProperty(value = "预览人数")
    private Integer reviewTotal;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
