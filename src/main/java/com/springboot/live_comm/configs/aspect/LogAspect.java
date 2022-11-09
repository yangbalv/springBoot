package com.springboot.live_comm.configs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {
    //    切入点符号分别表示任意返回值，任意类，任意方法，两个点表示任意请求参数
//    再写一个则可以分别进行切面配置
    @Pointcut("execution(* com.springboot.live_comm.service.*.*(..))")
    public void pc1() {
    }


    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行");
    }

    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束");
    }

    @AfterReturning(value = "pc1()", returning = "result")
    public void AfterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回值" + result);
    }

    @AfterThrowing(value = "pc1()", throwing = "e")
    public void AfterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛出异常了，异常是：" + e);
    }

    @Around(value = "pc1()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
