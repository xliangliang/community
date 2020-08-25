package com.liangliang.community.service;

import com.liangliang.community.dto.CityDto;
import com.liangliang.community.model.CCity;

import java.util.List;

/**
 * created by Liangliang on 2020/8/25
 */
public interface CityService {
    /**
     * 获取树形城市菜单
     */
    List<CityDto> getTreeCity(Integer id);

    /**
     * 根据id获取城市
     */
    CCity fingOne(Integer id);
}
