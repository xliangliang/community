package com.liangliang.community.mapper;

import com.liangliang.community.model.CResource;
import com.liangliang.community.model.CResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CResourceMapper {
    long countByExample(CResourceExample example);

    int deleteByExample(CResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CResource record);

    int insertSelective(CResource record);

    List<CResource> selectByExample(CResourceExample example);

    CResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CResource record, @Param("example") CResourceExample example);

    int updateByExample(@Param("record") CResource record, @Param("example") CResourceExample example);

    int updateByPrimaryKeySelective(CResource record);

    int updateByPrimaryKey(CResource record);
}