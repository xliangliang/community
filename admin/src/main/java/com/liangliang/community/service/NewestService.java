package com.liangliang.community.service;

import com.liangliang.community.dto.NewestDto;
import com.liangliang.community.model.CPublish;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/27
 * @desc
 */
public interface NewestService {
    /**
     * 所有最新问题
     */
    List<NewestDto> list(Integer pageNum, Integer pageSize);

    /**
     * 根据用户的所有问题
     */
    List<NewestDto> getUserQuestion(Long adminId, Integer pageNum, Integer pageSize);

    /**
     * 根据问题id查询问题详情
     */
    NewestDto getQuestionById(Integer questionId);
}
