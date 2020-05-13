package com.liangliang.community.dao;

import com.liangliang.community.dto.NewestDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by Liangliang on 2020/5/11
 */
public interface NewestDao {

    /**
     * 查询所有最新
     */
    List<NewestDto> selectAllNewest();

    /**
     * 根据用户的所有问题
     */
    List<NewestDto> selectAdminQuestion(@Param("adminId") Long adminId);

    /**
     * 根据问题id查询问题详情
     */
    NewestDto selectQuestion(@Param("questionId") Integer questionId);

    /**
     * 增加浏览数
     */
    Integer updateViewCount(@Param("questionId") Integer questionId);
}
