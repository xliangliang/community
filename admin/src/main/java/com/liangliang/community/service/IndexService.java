package com.liangliang.community.service;

import com.liangliang.community.dto.NewestDto;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/24
 * @desc
 */
public interface IndexService {
    /**
     * 获取主页最新全部问题
     */
    List<NewestDto> getAllNewest();
}
