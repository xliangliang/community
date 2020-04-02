package com.liangliang.community.mapper;

import com.liangliang.community.model.CUser;
import com.liangliang.community.model.CUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CUserMapper {
    long countByExample(CUserExample example);

    int deleteByExample(CUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CUser record);

    int insertSelective(CUser record);

    List<CUser> selectByExample(CUserExample example);

    CUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CUser record, @Param("example") CUserExample example);

    int updateByExample(@Param("record") CUser record, @Param("example") CUserExample example);

    int updateByPrimaryKeySelective(CUser record);

    int updateByPrimaryKey(CUser record);
}