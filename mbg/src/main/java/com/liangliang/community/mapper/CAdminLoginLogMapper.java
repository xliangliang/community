package com.liangliang.community.mapper;

import com.liangliang.community.model.CAdminLoginLog;
import com.liangliang.community.model.CAdminLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CAdminLoginLogMapper {
    long countByExample(CAdminLoginLogExample example);

    int deleteByExample(CAdminLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CAdminLoginLog record);

    int insertSelective(CAdminLoginLog record);

    List<CAdminLoginLog> selectByExample(CAdminLoginLogExample example);

    CAdminLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CAdminLoginLog record, @Param("example") CAdminLoginLogExample example);

    int updateByExample(@Param("record") CAdminLoginLog record, @Param("example") CAdminLoginLogExample example);

    int updateByPrimaryKeySelective(CAdminLoginLog record);

    int updateByPrimaryKey(CAdminLoginLog record);
}