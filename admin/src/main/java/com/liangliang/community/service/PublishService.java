package com.liangliang.community.service;

import com.liangliang.community.dto.PublishParam;

/**
 * @author Liangliang
 * @date 2020/4/23
 * @desc
 */
public interface PublishService {
    /**
     * 发布问题
     */
    Integer addQuestion(String token, PublishParam publishParam);
}
