package com.liangliang.community.service;

import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CResource;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/13
 * @desc 后台用户缓存操作类
 */
public interface AdminCacheService {

    /**
     * 获取缓存后台用户信息
     */
    CAdmin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(CAdmin admin);

    /**
     * 获取缓存后台用户资源列表
     */
    List<CResource> getResourceList(Long adminId);

    /**
     * 设置缓存后台用户资源列表
     */
    void setResourceList(Long adminId, List<CResource> resourceList);

    /**
     * 删除缓存后台用户信息
     */
    void delAdmin(String username);
}
