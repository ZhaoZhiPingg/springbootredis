package com.zzp.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(public int com.zzp.springboot.service.Impl.CalcServiceImpl.*(..))")
    public void beforeNotify(){
        System.out.println("********* @Before我是前置通知");
    }

    @After("execution(public int com.zzp.springboot.service.Impl.CalcServiceImpl.*(..))")
    public void afterNotify(){
        System.out.println("********* @After我是后置通知");
    }

    @AfterReturning("execution(public int com.zzp.springboot.service.Impl.CalcServiceImpl.*(..))")
    public void afterReturningNotify(){
        System.out.println("********* @AfterReturning我是返回后通知");
    }

    @AfterThrowing("execution(public int com.zzp.springboot.service.Impl.CalcServiceImpl.*(..))")
    public void afterThrowingNotify(){
        System.out.println("********* @AfterThrowing我是异常通知");
    }

    @Around("execution(public int com.zzp.springboot.service.Impl.CalcServiceImpl.*(..))")
    public Object aroundNotify(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue = null;
        System.out.println("********* @Around我是环绕通知之前AAA");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("********* @Around我是环绕通知之后BBB");
        return retValue;
    }

}
