package com.liangliang.community.dao;

import com.liangliang.community.model.CResource;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/10
 * @desc
 */
public interface ResourceDao {

    /**
     * 查询全部资源
     */
    List<CResource> listAll();
}
