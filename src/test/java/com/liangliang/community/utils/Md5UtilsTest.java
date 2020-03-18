package com.liangliang.community.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Md5UtilsTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void md5() {
        String token = Md5Utils.md5("123456");
        System.out.println(token);
        redisTemplate.opsForValue().set(token, 1);
        redisTemplate.opsForValue().set("1", token);
    }
}