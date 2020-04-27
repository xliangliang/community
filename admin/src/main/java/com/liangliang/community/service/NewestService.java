package com.liangliang.community.service;

import com.liangliang.community.model.CPublish;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/27
 * @desc
 */
public interface NewestService {
    /**
     * 所有最新问题
     */
    List<CPublish> list(Integer pageNum, Integer pageSize);
}
