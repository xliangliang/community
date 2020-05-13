package com.liangliang.community.service;

import com.liangliang.community.dto.CommentParam;
import com.liangliang.community.dto.CommentResult;
import com.liangliang.community.model.CComment;

import java.util.List;

/**
 * created by Liangliang on 2020/5/12
 */
public interface CommentSerivce {
    /**
     * 增加问题的回复
     */
    CComment addComment(Long adminId, CommentParam commentParam);

    /**
     * 根据问题id获取所有回复
     */
    List<CommentResult> getAllComment(Long questionId, Integer pageNum, Integer pageSize);
}
