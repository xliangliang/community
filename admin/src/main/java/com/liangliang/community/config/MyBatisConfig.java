package com.liangliang.community.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Liangliang
 * @date 2020/4/10
 * @desc
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.liangliang.community.dao","com.liangliang.community.mapper"})
public class MyBatisConfig {
}
