package com.liangliang.community.service.impl;

import com.liangliang.community.model.CAdmin;
import com.liangliang.community.model.CResource;
import com.liangliang.community.security.service.RedisService;
import com.liangliang.community.service.AdminCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liangliang
 * @date 2020/4/13
 * @desc
 */
@Service
public class AdminCacheServiceImpl implements AdminCacheService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;

    @Override
    public CAdmin getAdmin(String username) {
        String key = REDIS_KEY_ADMIN + ":" + username;
        return (CAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(CAdmin admin) {
        String key = REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public List<CResource> getResourceList(Long adminId) {
        String key = REDIS_KEY_ADMIN + ":" + adminId;
        return (List<CResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<CResource> resourceList) {
        String key = REDIS_KEY_ADMIN + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }

    @Override
    public void delAdmin(String username) {
        String key = REDIS_KEY_ADMIN + ":" + username;
        redisService.del(key);
    }
}
