package com.liangliang.community.service.impl;

import com.github.pagehelper.PageHelper;
import com.liangliang.community.dao.NewestDao;
import com.liangliang.community.dto.NewestDto;
import com.liangliang.community.service.NewestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/27
 * @desc
 */
@Service
public class NewestServiceImpl implements NewestService {

    @Autowired
    private NewestDao newestDao;

    @Override
    public List<NewestDto> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return newestDao.selectAllNewest();
    }

    @Override
    public List<NewestDto> getUserQuestion(Long adminId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return newestDao.selectAdminQuestion(adminId);
    }

    @Override
    public NewestDto getQuestionById(Integer questionId) {
        // 增加浏览数
        newestDao.updateViewCount(questionId);
        return newestDao.selectQuestion(questionId);
    }
}
