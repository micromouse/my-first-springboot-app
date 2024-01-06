package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 执行操作运行时间记录
 */
@Order(2)
@Slf4j
@Component
@Aspect
public class StopwatchAspect {
    /**
     * 执行控制器操作运行时间记录
     *
     * @param joinPoint ：要执行的控制器方法
     * @return ：控制器方法返回结果
     * @throws Throwable ：向上抛出异常
     */
    @Around("com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Aop.AdviceAspect.commonPointcut()")
    public Object StopwatchByController(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            log.info("当前请求[{}]耗时:{}ms", joinPoint.getSignature(), end - start);
        }
    }
}
