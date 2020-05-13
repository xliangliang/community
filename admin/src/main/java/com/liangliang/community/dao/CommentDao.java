package com.liangliang.community.dao;

import com.liangliang.community.dto.CommentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by Liangliang on 2020/5/13
 */
public interface CommentDao {
    /**
     * 据问题id获取所有回复
     */
    List<CommentResult> selectAllComment(@Param("questionId") Long questionId);
}
