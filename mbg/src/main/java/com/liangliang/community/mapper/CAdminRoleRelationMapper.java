package com.liangliang.community.mapper;

import com.liangliang.community.model.CAdminRoleRelation;
import com.liangliang.community.model.CAdminRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CAdminRoleRelationMapper {
    long countByExample(CAdminRoleRelationExample example);

    int deleteByExample(CAdminRoleRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CAdminRoleRelation record);

    int insertSelective(CAdminRoleRelation record);

    List<CAdminRoleRelation> selectByExample(CAdminRoleRelationExample example);

    CAdminRoleRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CAdminRoleRelation record, @Param("example") CAdminRoleRelationExample example);

    int updateByExample(@Param("record") CAdminRoleRelation record, @Param("example") CAdminRoleRelationExample example);

    int updateByPrimaryKeySelective(CAdminRoleRelation record);

    int updateByPrimaryKey(CAdminRoleRelation record);
}