package com.liangliang.community.service.impl;

import com.liangliang.community.dao.ResourceDao;
import com.liangliang.community.mapper.CResourceMapper;
import com.liangliang.community.model.CResource;
import com.liangliang.community.model.CResourceExample;
import com.liangliang.community.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/10
 * @desc
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private CResourceMapper resourceMapper;

    @Override
    public int create(CResource cResource) {
        return 0;
    }

    @Override
    public List<CResource> listAll() {
        return resourceDao.listAll();
        //return resourceMapper.selectByExample(new CResourceExample());
    }
}
