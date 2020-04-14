package com.liangliang.community.security.aspect;

import com.liangliang.community.security.annotation.CacheException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Liangliang
 * @date 2020/4/14
 * @desc Redis缓存切面，放纸redis宕机影响正常业务逻辑
 */
@Aspect
@Component
public class RedisCacheAspect {
    private final Logger logger = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Pointcut("execution(public * com.liangliang.community.service.*CacheService.*(..))")
    public void cacheAspect() {
    }

    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            if (method.isAnnotationPresent(CacheException.class)) {
                throw throwable;
            } else {
                logger.error(throwable.getMessage());
            }
        }
        return result;
    }
}
