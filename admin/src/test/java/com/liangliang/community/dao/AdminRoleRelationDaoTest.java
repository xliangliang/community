package com.liangliang.community.dao;

import com.liangliang.community.model.CResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Liangliang
 * @date 2020/4/17
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRoleRelationDaoTest {

    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;

    @Test
    public void getResourceList() {
        List<CResource> resourceList = adminRoleRelationDao.getResourceList(1L);
        for (CResource resource : resourceList) {
            System.out.println(resource.toString());
        }
    }
}