package com.liangliang.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.liangliang.community.controller")
@ComponentScan("com.liangliang.community.provider")
@ComponentScan("com.liangliang.community.service.impl")
@MapperScan("com.liangliang.community.dao.mapper")
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
