package com.liangliang.community.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * created by Liangliang on 2020/8/25
 */
@Data
public class CityDto {
    @ApiModelProperty(value = "城市id")
    private Integer id;
    @ApiModelProperty(value = "父类id")
    private Integer parentId;
    @ApiModelProperty(value = "城市省份名")
    private String name;
    private List<CityDto> list;
}
