package com.liangliang.community.security.annotation;

import java.lang.annotation.*;

/**
 * @author：Liangliang
 * @date：2020/4/10 10:45
 * @desc：自定义注解
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
