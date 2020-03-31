package com.liangliang.community;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.liangliang.community.controller")
@ComponentScan("com.liangliang.community.service")
@MapperScan("com.liangliang.community.mapper")
public class CommunityApplication {

    private static final Logger logger = LoggerFactory.getLogger(CommunityApplication.class);
    public static void main(String[] args) {
        logger.info("项目启动中...");
        SpringApplication.run(CommunityApplication.class, args);
        logger.info("项目已启动");
    }

}
