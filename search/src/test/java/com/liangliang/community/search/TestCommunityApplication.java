package com.liangliang.community.search;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.liangliang.community.search.dao")
@ComponentScan("com.liangliang.community.search.service")
@ComponentScan("com.liangliang.community.search.controller")
public class TestCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCommunityApplication.class, args);
    }

}
