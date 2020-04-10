package com.liangliang.community.service;

import com.liangliang.community.model.CResource;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/10
 * @desc
 */
public interface ResourceService {
    /**
     * 添加资源
     */
    int create(CResource cResource);

    /**
     * 查询全部资源
     */
    List<CResource> listAll();
}
