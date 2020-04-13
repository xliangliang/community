package com.liangliang.community.dao;

import com.liangliang.community.model.CResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/13
 * @desc 用户、角色关系
 */
public interface AdminRoleRelationDao {
    /**
     * 获取用户所有可访问资源
     */
    List<CResource> getResourceList(@Param("adminId") Long adminId);
}
