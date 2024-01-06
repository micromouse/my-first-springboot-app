package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AnnotationAspect {
    /**
     * Aspect通用切入点,使用注解表上切入点
     */
    @Pointcut("@annotation(com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Aop.MyAnnotationPointcut)")
    public void common() {

    }

    /**
     * 注解[MyAnnotation]方法执行前
     *
     * @param joinPoint : 连接点
     */
    @Before("common()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("注解[MyAnnotation] 方法[{}.{}] before ...", className, methodName);
    }
}
