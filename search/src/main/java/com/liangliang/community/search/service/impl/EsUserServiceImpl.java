package com.liangliang.community.search.service.impl;

import com.liangliang.community.search.dao.EsUserDao;
import com.liangliang.community.search.service.EsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Liangliang
 * @date 2020/3/31
 * @desc
 */
@Service
public class EsUserServiceImpl implements EsUserService {

    @Autowired
    private EsUserDao esUserDao;

    @Override
    public int userTotalNum() {
        return esUserDao.selectAllUser();
    }
}
