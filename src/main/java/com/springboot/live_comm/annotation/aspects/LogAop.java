package com.springboot.live_comm.annotation.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAop {


    /*
     * 这是一个切入点
     * */
//    @Pointcut("execution(* com.springboot.live_comm.controller.*Controller.*(..))")
//
    @Pointcut("@annotation(com.springboot.live_comm.annotation.interfaces.MyLog)")

    public void logger() {
    }


    @Around("logger()")
    public Object around(ProceedingJoinPoint point) {
        log.info(Arrays.toString(point.getArgs()));
        //获取方法名称
        Signature methodName = point.getSignature();
        //日志输出
        log.info(methodName + "进来了");
        Long l1 = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = point.proceed(point.getArgs());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info(methodName + "bye" + "\t耗時 " + (System.currentTimeMillis() - l1));
//记录一个耗时时间，将证明日志通知
        return obj;
    }

}