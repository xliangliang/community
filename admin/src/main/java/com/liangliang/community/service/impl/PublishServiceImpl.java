package com.liangliang.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.liangliang.community.dto.PublishParam;
import com.liangliang.community.mapper.CPublishMapper;
import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CPublish;
import com.liangliang.community.security.utils.JwtTokenUtil;
import com.liangliang.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Liangliang
 * @date 2020/4/23
 * @desc
 */
@Service
public class PublishServiceImpl implements PublishService {
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private CPublishMapper publishMapper;
    @Autowired
    private AdminCacheServiceImpl adminCacheService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public int addQuestion(Long adminId, PublishParam publishParam) {
        CPublish publish = new CPublish();
        BeanUtil.copyProperties(publishParam, publish);
        publish.setAdminId(adminId);
        publish.setCreateTime(new Date());
        publish.setViewCount(0);
        publish.setCommentCount(0);
        return publishMapper.insert(publish);
    }
}
