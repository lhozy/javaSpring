package com.lhozy.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect()   //spring内置的四种通知执行顺序有一定的问题：
                // 前置通知
                //执行save方法
                // 最终通知
                //后置通知
                //                   建议使用环绕通知，自定义
public class Logger {
    @Pointcut("execution(* com.lhozy.service.impl.*.*(..))")//定义表达式
    public void pt1(){}

//    @Before("execution(* com.lhozy.service.impl.*.*(..))")
    //@Before("pt1()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }
    //@AfterReturning("pt1()")
    public void afterAdvice(){
        System.out.println("后置通知");
    }
    //@AfterThrowing("pt1()")
    public void exceptionAdvice(){
        System.out.println("异常通知");
    }
    //@After("pt1()")
    public void finalAdvice(){
        System.out.println("最终通知");
    }
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Integer id = 0;
            Object[] args = pjp.getArgs();//得到方法的参数
            System.out.println(args.length);
            if (args != null && args.length != 0) {
                id = (Integer) args[0];
                id = (Integer) args[0] + 1;//增强需求把参数+1
            }
            System.out.println(id);
            System.out.println("方法执行之前----前置通知");
            rtValue = pjp.proceed(args);//回调(切入点方法)
            System.out.println("方法执行之后----后置通知");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("方法执行出现异常----异常通知");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("一定会执行----最终通知");
        }
    }

}
