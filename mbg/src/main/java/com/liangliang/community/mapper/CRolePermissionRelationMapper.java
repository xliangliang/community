package com.liangliang.community.mapper;

import com.liangliang.community.model.CRolePermissionRelation;
import com.liangliang.community.model.CRolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CRolePermissionRelationMapper {
    long countByExample(CRolePermissionRelationExample example);

    int deleteByExample(CRolePermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CRolePermissionRelation record);

    int insertSelective(CRolePermissionRelation record);

    List<CRolePermissionRelation> selectByExample(CRolePermissionRelationExample example);

    CRolePermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CRolePermissionRelation record, @Param("example") CRolePermissionRelationExample example);

    int updateByExample(@Param("record") CRolePermissionRelation record, @Param("example") CRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(CRolePermissionRelation record);

    int updateByPrimaryKey(CRolePermissionRelation record);
}