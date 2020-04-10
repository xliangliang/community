package com.liangliang.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author：Liangliang
 * @date：2020/4/10 11:07
 * @desc：测试自定义注解
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(public * com.liangliang.community.service.*Service.*(..))")
    public void testAspect(){
    }

    @Around("testAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("11111111:"+joinPoint.getSignature());
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("result:"+result.toString());
        } catch (Throwable throwable) {
            System.out.println("Errorrrrrrrrrrrrrrrr");
        }
        return result;
    }
}
