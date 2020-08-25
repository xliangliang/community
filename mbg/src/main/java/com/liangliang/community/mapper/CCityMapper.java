package com.liangliang.community.mapper;

import com.liangliang.community.model.CCity;
import com.liangliang.community.model.CCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCityMapper {
    long countByExample(CCityExample example);

    int deleteByExample(CCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CCity record);

    int insertSelective(CCity record);

    List<CCity> selectByExample(CCityExample example);

    CCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CCity record, @Param("example") CCityExample example);

    int updateByExample(@Param("record") CCity record, @Param("example") CCityExample example);

    int updateByPrimaryKeySelective(CCity record);

    int updateByPrimaryKey(CCity record);
}