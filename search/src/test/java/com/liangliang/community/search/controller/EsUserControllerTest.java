package com.liangliang.community.search.controller;

import com.liangliang.community.search.TestCommunityApplication;
import com.liangliang.community.search.service.impl.EsUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestCommunityApplication.class)
public class EsUserControllerTest {

    @Autowired
    private EsUserServiceImpl esUserService;

    @Test
    public void userTotalNum() {
        System.out.println(esUserService.userTotalNum());
    }
}