package com.liangliang.community.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author Liangliang
 * @date 2020/4/7
 * @desc
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应的MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
