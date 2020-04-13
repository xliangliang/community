package com.liangliang.community.mapper;

import com.liangliang.community.model.CRole;
import com.liangliang.community.model.CRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CRoleMapper {
    long countByExample(CRoleExample example);

    int deleteByExample(CRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CRole record);

    int insertSelective(CRole record);

    List<CRole> selectByExample(CRoleExample example);

    CRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CRole record, @Param("example") CRoleExample example);

    int updateByExample(@Param("record") CRole record, @Param("example") CRoleExample example);

    int updateByPrimaryKeySelective(CRole record);

    int updateByPrimaryKey(CRole record);
}