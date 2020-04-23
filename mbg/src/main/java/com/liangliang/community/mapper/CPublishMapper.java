package com.liangliang.community.mapper;

import com.liangliang.community.model.CPublish;
import com.liangliang.community.model.CPublishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CPublishMapper {
    long countByExample(CPublishExample example);

    int deleteByExample(CPublishExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CPublish record);

    int insertSelective(CPublish record);

    List<CPublish> selectByExample(CPublishExample example);

    CPublish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CPublish record, @Param("example") CPublishExample example);

    int updateByExample(@Param("record") CPublish record, @Param("example") CPublishExample example);

    int updateByPrimaryKeySelective(CPublish record);

    int updateByPrimaryKey(CPublish record);
}