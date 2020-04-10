package com.liangliang.community.mapper;

import com.liangliang.community.model.CResourceCategory;
import com.liangliang.community.model.CResourceCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CResourceCategoryMapper {
    long countByExample(CResourceCategoryExample example);

    int deleteByExample(CResourceCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CResourceCategory record);

    int insertSelective(CResourceCategory record);

    List<CResourceCategory> selectByExample(CResourceCategoryExample example);

    CResourceCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CResourceCategory record, @Param("example") CResourceCategoryExample example);

    int updateByExample(@Param("record") CResourceCategory record, @Param("example") CResourceCategoryExample example);

    int updateByPrimaryKeySelective(CResourceCategory record);

    int updateByPrimaryKey(CResourceCategory record);
}