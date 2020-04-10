package com.liangliang.community.annotation;

import java.lang.annotation.*;

/**
 * @author：Liangliang
 * @date：2020/4/10 11:05
 * @desc：测试自定义注解
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
}
