package com.liangliang.community.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * created by Liangliang on 2020/5/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MinioUploadDto {
    @ApiModelProperty("文件访问URL")
    private String url;
    @ApiModelProperty("文件名称")
    private String name;
}
