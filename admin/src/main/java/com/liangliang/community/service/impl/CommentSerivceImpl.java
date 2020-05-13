package com.liangliang.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.liangliang.community.dao.CommentDao;
import com.liangliang.community.dto.CommentParam;
import com.liangliang.community.dto.CommentResult;
import com.liangliang.community.mapper.CCommentMapper;
import com.liangliang.community.model.CComment;
import com.liangliang.community.service.CommentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * created by Liangliang on 2020/5/12
 */
@Service
public class CommentSerivceImpl implements CommentSerivce {

    @Autowired
    private CCommentMapper commentMapper;
    @Autowired
    private CommentDao commentDao;

    @Override
    public CComment addComment(Long adminId, CommentParam commentParam) {
        CComment comment = new CComment();
        BeanUtil.copyProperties(commentParam, comment);
        comment.setCommentator(adminId);
        comment.setCreateTime(new Date());
        int count = commentMapper.insert(comment);
        if (count != 1) {
            return null;
        }
        return comment;
    }

    @Override
    public List<CommentResult> getAllComment(Long questionId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return commentDao.selectAllComment(questionId);
    }
}
