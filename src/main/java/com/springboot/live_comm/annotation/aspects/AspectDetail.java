package com.springboot.live_comm.annotation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

//参考
//https://blog.csdn.net/java_green_hand0909/article/details/90238242
//https://blog.csdn.net/qq_22167989/article/details/83962954
@Component
@Aspect
@Order(0)
public class AspectDetail implements Ordered {
    @Pointcut("@annotation(com.springboot.live_comm.annotation.interfaces.StartAndEndInstructions)")
    public void pointcut() {
//        该方法仅作为切入点的载体，其中的内容不会执行
    }

    // 环绕增强
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before");
        Object retVal = pjp.proceed();
        System.out.println("around after");
        return retVal;
    }

    // 前置增强
    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    // 后置finally增强
    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    // 后置return增强
    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("after returning");
    }

    // 抛出增强
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("afterThrowing");
    }

//正常运行结果
//    around before
//    before
//    //method execute
//    around after
//    after
//    after returning

//抛出异常时的结果
//    around before
//    before
////method execute
//            after
//    afterThrowing

//    因而对于五种增强类型的执行顺序如下
//    环绕增强前(around advice before)
//    前置增强(before advice)
//-- 方法执行
//    环绕增强后(around advice after)
//    后置finally增强(after advice)
//    后置增强/抛出增强


    //    如果存在两个相同类型的Advice，如何进行排序？答案Spring AOP不支持Advice层级的排序，只支持Aspect层级的排序。不同的Aspect通过实现Ordered接口，或使用@Order注解设置优先级。对于getOrder返回的值或@Order中设置的值，值越小优先级越高。
    //    设置当前类中的Aspect的优先级值越小优先级越高
//    实现Ordered重写getOrder
//   或者加上@Order()注解
    @Override
    public int getOrder() {

        return 0;
    }


}
