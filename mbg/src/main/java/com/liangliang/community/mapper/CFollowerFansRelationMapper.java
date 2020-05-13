package com.liangliang.community.mapper;

import com.liangliang.community.model.CFollowerFansRelation;
import com.liangliang.community.model.CFollowerFansRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CFollowerFansRelationMapper {
    long countByExample(CFollowerFansRelationExample example);

    int deleteByExample(CFollowerFansRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CFollowerFansRelation record);

    int insertSelective(CFollowerFansRelation record);

    List<CFollowerFansRelation> selectByExample(CFollowerFansRelationExample example);

    CFollowerFansRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CFollowerFansRelation record, @Param("example") CFollowerFansRelationExample example);

    int updateByExample(@Param("record") CFollowerFansRelation record, @Param("example") CFollowerFansRelationExample example);

    int updateByPrimaryKeySelective(CFollowerFansRelation record);

    int updateByPrimaryKey(CFollowerFansRelation record);
}