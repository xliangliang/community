package com.liangliang.community.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liangliang
 * @date 2020/3/31
 * @desc
 */
@Configuration
@MapperScan("com.liangliang.community.search.dao")
public class MyBatisConfig {
}
