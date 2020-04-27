package com.liangliang.community.service.impl;

import com.github.pagehelper.PageHelper;
import com.liangliang.community.mapper.CPublishMapper;
import com.liangliang.community.model.CPublish;
import com.liangliang.community.model.CPublishExample;
import com.liangliang.community.service.NewestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/27
 * @desc
 */
@Service
public class NewestServiceImpl implements NewestService {

    @Autowired
    private CPublishMapper publishMapper;

    @Override
    public List<CPublish> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        CPublishExample example = new CPublishExample();
        example.createCriteria().andAdminIdIsNotNull();
        return publishMapper.selectByExample(example);
    }
}
