package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Aop;

import com.studies.myfirstspringbootapp.web.demos.web.service.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Aspect通知
 */
@Order(1)
@Slf4j
@Component
@Aspect
public class AdviceAspect {
    /**
     * Aspect通用切入点
     */
    @Pointcut("execution(* com.studies.myfirstspringbootapp.web.demos.web.controllers.*.*(..)) ")
    public void commonPointcut() {
    }

    /**
     * 方法执行前通知
     */
    @Before("commonPointcut()")
    public void before() {
        log.info("before ...");
    }

    /**
     * 方法环绕通知(方法执行前/后通知)
     * ---------------------------------
     * 正常请求http://localhost:8081/login顺序执行下列通知
     * around before ...
     * before ...
     * afterReturning ...
     * after ...
     * around after ...
     * ---------------------------------
     * 请求http://localhost:8081/login抛出异常时顺序执行下列通知
     * around before ...
     * before ...
     * afterThrowing ...
     * after ...
     * ---------------------------------
     *
     * @param joinPoint : 处理切入点
     */
    @Around("commonPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around before ...");

        Object obj = joinPoint.proceed();
        log.info("around after ...");

        return obj;
    }

    /**
     * 方法执行后通知，无论是否有异常都会通知
     */
    @After("commonPointcut()")
    public void after() {
        log.info("after ...");
    }

    /**
     * 方法正常执行后通知,有异常不会执行
     */
    @AfterReturning("commonPointcut()")
    public void afterReturning() {
        log.info("afterReturning ...");
    }

    /**
     * 方法执行异常后通知(controllers和dao下的异常执行将被通知)
     */
    @AfterThrowing("execution(* com.studies.myfirstspringbootapp.web.demos.web.controllers.*.*(..)) ||" +
            "execution(* com.studies.myfirstspringbootapp.web.demos.web.dao.*.*(..))")
    public void afterThrowing() {
        log.info("afterThrowing ...");
    }

    /**
     * 执行[com.studies.myfirstspringbootapp.web.demos.web.service]下所有接口方法前通知
     * @param joinPoint ：连接点
     */
    @Before("execution(* com..service.*.*(..))")
    public void interfaceBefore(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        log.info("request [{}/{}] before ...", className, methodName);
    }
}
