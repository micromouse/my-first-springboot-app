package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Aop;

import lombok.extern.slf4j.Slf4j;
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
     */
    @Before("common()")
    public void before(){
        log.info("注解[MyAnnotation] before ...");
    }
}
