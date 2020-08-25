package com.liangliang.community.dao;

import com.liangliang.community.dto.CityDto;
import com.liangliang.community.model.CCity;

import java.util.List;

/**
 * created by Liangliang on 2020/8/25
 */
public interface CityDao {
    /**
     * 获取树形数据
     */
    List<CityDto> findCity(Integer id);

    CCity findOne(Integer id);
}
