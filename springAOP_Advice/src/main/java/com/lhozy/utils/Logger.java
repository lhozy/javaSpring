package com.lhozy.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    public void beforeAdvice(){
        System.out.println("前置通知");
    }
    public void afterAdvice(){
        System.out.println("后置通知");
    }
    public void exceptionAdvice(){
        System.out.println("异常通知");
    }
    public void finalAdvice(){
        System.out.println("最终通知");
    }
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
