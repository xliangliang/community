package com.liangliang.community.mapper;

import com.liangliang.community.model.CPermission;
import com.liangliang.community.model.CPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CPermissionMapper {
    long countByExample(CPermissionExample example);

    int deleteByExample(CPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CPermission record);

    int insertSelective(CPermission record);

    List<CPermission> selectByExample(CPermissionExample example);

    CPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CPermission record, @Param("example") CPermissionExample example);

    int updateByExample(@Param("record") CPermission record, @Param("example") CPermissionExample example);

    int updateByPrimaryKeySelective(CPermission record);

    int updateByPrimaryKey(CPermission record);
}