package com.liangliang.community.search.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Liangliang
 * @date 2020/3/31
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsUserControllerTest {

    @Autowired
    private EsUserController esUserController;

    @Test
    public void testEsUserController() {
        System.out.println(esUserController.userTotalNum());
    }
}
