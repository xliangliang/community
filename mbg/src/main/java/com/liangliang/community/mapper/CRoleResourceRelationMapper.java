package com.liangliang.community.mapper;

import com.liangliang.community.model.CRoleResourceRelation;
import com.liangliang.community.model.CRoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CRoleResourceRelationMapper {
    long countByExample(CRoleResourceRelationExample example);

    int deleteByExample(CRoleResourceRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CRoleResourceRelation record);

    int insertSelective(CRoleResourceRelation record);

    List<CRoleResourceRelation> selectByExample(CRoleResourceRelationExample example);

    CRoleResourceRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CRoleResourceRelation record, @Param("example") CRoleResourceRelationExample example);

    int updateByExample(@Param("record") CRoleResourceRelation record, @Param("example") CRoleResourceRelationExample example);

    int updateByPrimaryKeySelective(CRoleResourceRelation record);

    int updateByPrimaryKey(CRoleResourceRelation record);
}