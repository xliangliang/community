package com.liangliang.community.dao;

import com.liangliang.community.dto.AdminDetailInfoDto;
import org.apache.ibatis.annotations.Param;

/**
 * created by Liangliang on 2020/5/12
 */
public interface FollowerFansRelationDao {
    AdminDetailInfoDto selectAdminDetailInfo(@Param("id") Long id);
}
