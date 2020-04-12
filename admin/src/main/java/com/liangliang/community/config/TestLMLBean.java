package com.liangliang.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestLMLBean {

    //@Bean
    //@Primary
    public void testLMLBean(){
        System.out.println("TestBean--------------------");
    }
}
