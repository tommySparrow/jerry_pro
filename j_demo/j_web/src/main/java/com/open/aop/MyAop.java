package com.open.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2018/8/9
 * @ Description：
 * @ throws
 */
@Component
@Aspect
public class MyAop {

    @Pointcut("execution(* com.open.controller..*(..)))")
    public  void aspct(){
    }

    @Around("aspct()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("执行了自己创建的aop++++++++++++++1");//在要"执行访问的功能"之前执行
        Object proceed = pjp.proceed();//执行访问的功能
        System.out.println("执行了自己创建的aop++++++++++++++2");
        return proceed;
    }
}
