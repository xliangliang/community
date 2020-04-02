package com.liangliang.community.mapper;

import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CAdminMapper {
    long countByExample(CAdminExample example);

    int deleteByExample(CAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CAdmin record);

    int insertSelective(CAdmin record);

    List<CAdmin> selectByExample(CAdminExample example);

    CAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CAdmin record, @Param("example") CAdminExample example);

    int updateByExample(@Param("record") CAdmin record, @Param("example") CAdminExample example);

    int updateByPrimaryKeySelective(CAdmin record);

    int updateByPrimaryKey(CAdmin record);
}