package com.liangliang.community.service.impl;

import com.liangliang.community.dao.CityDao;
import com.liangliang.community.dto.CityDto;
import com.liangliang.community.model.CCity;
import com.liangliang.community.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by Liangliang on 2020/8/25
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public List<CityDto> getTreeCity(Integer id) {
        return cityDao.findCity(id);
    }

    @Override
    public CCity fingOne(Integer id) {
        return cityDao.findOne(id);
    }
}
