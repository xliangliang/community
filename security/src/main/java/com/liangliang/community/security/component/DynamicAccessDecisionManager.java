package com.liangliang.community.security.component;

import cn.hutool.core.collection.CollUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Liangliang
 * @date 2020/4/3
 * @desc
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o,
                       Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //当接口未配置资源时直接放行
        if (CollUtil.isEmpty(collection)) {
            return;
        }
        Iterator<ConfigAttribute> it = collection.iterator();
        while (it.hasNext()) {
            ConfigAttribute configAttribute = it.next();
            //将访问所需资源或用户拥有资源进行对比
            String needAuthority = configAttribute.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needAuthority.trim().equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("抱歉，您没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
