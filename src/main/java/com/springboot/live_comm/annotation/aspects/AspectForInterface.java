package com.springboot.live_comm.annotation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

//参考
//https://blog.csdn.net/java_green_hand0909/article/details/90238242

//
//AOP的基本概念
//        Advice(通知、切面)： 某个连接点所采用的处理逻辑，也就是向连接点注入的代码， AOP在特定的切入点上执行的增强处理。
//@Before： 标识一个前置增强方法，相当于BeforeAdvice的功能.
//@After： final增强，不管是抛出异常或者正常退出都会执行.
//@AfterReturning：  后置增强，似于AfterReturningAdvice, 方法正常退出时执行.
//@AfterThrowing：  异常抛出增强，相当于ThrowsAdvice.
//@Around： 环绕增强，相当于MethodInterceptor.
//关于 Advice的优先级
//https://blog.csdn.net/qq_22167989/article/details/83962954
@Component
@Aspect
public class AspectForInterface {

    private static final String REQUEST_LOG_ID = "_request_log_id";
    private static final String SESSION_ID = "sessionId";
    private static final String REMOTE_HOST = "remoteHost";
    private static final String REMOTE_ADDR = "remoteAddr";

//    Pointcut
//    表示式(expression)和签名(signature)
//    //Pointcut表示式
//    @Pointcut("execution(* com.savage.aop.MessageSender.*(..))")
////Point签名
//    private void log(){}

//    由下列方式来定义或者通过 &&、 ||、 !、 的方式进行组合：
//    execution：用于匹配方法执行的连接点；
//    within：用于匹配指定类型内的方法执行；
//    this：用于匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配；
//    target：用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就不包括引入接口也类型匹配；
//    args：用于匹配当前执行的方法传入的参数为指定类型的执行方法；
//    @within：用于匹配所以持有指定注解类型内的方法；
//    @target：用于匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解；
//    @args：用于匹配当前执行的方法传入的参数持有指定注解的执行；
//    @annotation：用于匹配当前执行方法持有指定注解的方法；
//    最初的理解：
//
//    execution(表达式匹配)
//
//    within(指定某个类)
//        this(当前类的)


//格式
//execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
//    其中后面跟着“?”的是可选项
//    括号中各个pattern分别表示：
//    修饰符匹配（modifier-pattern?）
//    返回值匹配（ret-type-pattern）：   可以为*表示任何返回值, 全路径的类名等
//    类路径匹配（declaring-type-pattern?）
//    方法名匹配（name-pattern）：可以指定方法名 或者 *代表所有, set* 代表以set开头的所有方法
//    参数匹配（(param-pattern)）：可以指定具体的参数类型，多个参数间用“,”隔开，各个参数也可以用"*" 来表示匹配任意类型的参数，".."表示零个或多个任意参数。
//    如(String)表示匹配一个String参数的方法；(*,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型。
//    异常类型匹配（throws-pattern?）


    //表达式中的@annotation表示切入点是注解
    @Pointcut("execution( * com.springboot.live_comm.*controller.*(..))")
    public void methodForPointForExecution() {
//        该方法仅作为切入点的载体，其中的内容不会执行
    }

    //表达式中的@annotation表示切入点是注解
    @Pointcut("execution(* java.io.PrintStream.println(..))")
    public void aa() {

//        该方法仅作为切入点的载体，其中的内容不会执行
    }

    @Before("aa()")
    public void aaBefore() {
        System.out.printf("%s", "不知道哪个沙雕在代码里面使用了println()");
    }
    //    这是注解的切面的设计

    //表达式中的@annotation表示切入点是注解
    @Pointcut("@annotation(com.springboot.live_comm.annotation.interfaces.StartAndEndInstructions)")
    public void methodForPointForAnnotation() {
//        该方法仅作为切入点的载体，其中的内容不会执行
    }

    // 环绕增强
    @Around("methodForPointForAnnotation()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before");
        Object retVal = pjp.proceed();
        System.out.println("around after");
        return retVal;
    }

    // 前置增强
    @Before("methodForPointForAnnotation()")
    public void before() {
        System.out.println("before");
    }

    // 后置finally增强
    @After("methodForPointForAnnotation()")
    public void after() {
        System.out.println("after");
    }

    // 后置return增强
    @AfterReturning("methodForPointForAnnotation()")
    public void afterReturning() {
        System.out.println("after returning");
    }

    // 抛出增强
    @AfterThrowing(value = "methodForPointForAnnotation()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("afterThrowing");
    }


    @Before("methodForPointForAnnotation()")
    public void checkMessage(JoinPoint joinPoint) {
        System.out.println("基于注解的切面");
        System.out.println(joinPoint.getSignature().toString());
        System.out.println(joinPoint.getSignature().toShortString());
        System.out.println(joinPoint.getSignature().toLongString());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getSignature().getModifiers());
        System.out.println(joinPoint.getSignature().getDeclaringType());
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
    }


    //    打印请求参数
    @Before("methodForPointForAnnotation()")
    public void requestLog(JoinPoint joinPoint) {
        int jionPointId = joinPoint.hashCode();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String logId = UUID.randomUUID().toString();
        MDC.put(REQUEST_LOG_ID, logId);
        MDC.put(SESSION_ID, request.getRequestedSessionId());
        MDC.put(REMOTE_HOST, request.getRemoteHost());
        MDC.put(REMOTE_ADDR, request.getRemoteAddr());
        String sb =
                "URL : " + request.getRequestURL().toString() +
                        " " + request.getMethod() +
                        " 请求开始..." +
                        "\nCLASS_METHOD : " + "joinPoint.getSignature().getDeclaringTypeName()" + "." + joinPoint.getSignature().getName() +
                        "\n请求参数 : " + Arrays.toString(joinPoint.getArgs());
        System.out.println(sb);
    }


    //打印响应参数
    @AfterReturning(returning = "response", pointcut = "methodForPointForAnnotation()")
    public void afterReturning(Object response) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object logId = MDC.get(REQUEST_LOG_ID);
        String sb =
                "URL : " + request.getRequestURL().toString() +
                        " 请求成功..." +
                        "\n响应参数 : " + response;
        System.out.println(sb);
        MDC.remove(REQUEST_LOG_ID);
    }

    //打印异常
    @AfterThrowing(pointcut = "methodForPointForAnnotation()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String sb =
                "URL : " + request.getRequestURL().toString() +
                        " 请求失败..." +
                        "\n异常类型 : " + e.getClass() +
                        "\n异常信息 : " + e.getMessage();
        System.out.println(sb);
        System.out.println("详细信息:" + e);
    }
//
//    @Pointcut("")
//    public void methodForPointFor(JoinPoint joinPoint) {
//        // 获取方法签名
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        // 获取了目标方法
//        Method method = signature.getMethod();
//        // 获取目标方法上的指定注解AccountEntrance
//        StartAndEndInstructions annotation = method.getAnnotation(StartAndEndInstructions.class);
////        这一步是获取注解中的参数
//        System.out.println(annotation.type());
//
//    }

}
