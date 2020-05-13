package com.liangliang.community.mapper;

import com.liangliang.community.model.CComment;
import com.liangliang.community.model.CCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCommentMapper {
    long countByExample(CCommentExample example);

    int deleteByExample(CCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CComment record);

    int insertSelective(CComment record);

    List<CComment> selectByExample(CCommentExample example);

    CComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CComment record, @Param("example") CCommentExample example);

    int updateByExample(@Param("record") CComment record, @Param("example") CCommentExample example);

    int updateByPrimaryKeySelective(CComment record);

    int updateByPrimaryKey(CComment record);
}