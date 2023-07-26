package com.springboot.live_comm.annotation.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectForPointcut {
//    ElementType.TYPE：能修饰类、接口或枚举类型
//    ElementType.FIELD：能修饰成员变量
//    ElementType.METHOD：能修饰方法
//    ElementType.PARAMETER：能修饰参数
//    ElementType.CONSTRUCTOR：能修饰构造器
//    ElementType.LOCAL_VARIABLE：能修饰局部变量
//    ElementType.ANNOTATION_TYPE：能修饰注解
//    ElementType.PACKAGE：能修饰包


    public void example() {
        log.info("我是一个内部方法");
    }

    //    Pointcut可以直接指定到别的已经定义好的Pointcut
    @Pointcut("pointcutForExecution()")
    public void pointcutForOtherPointcut() {
    }

    //-------------------指向类中方法---------------------
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
    @Pointcut("execution( * example())")
//    execution表达式的最小内容，只包含返回值类型和方法名ret_type_pattern, name_pattern
    public void pointcutForOtherExecution() {
    }

    @Pointcut("execution(public * com.springboot.live_comm.annotation.controller.ControllerForExecution.*(..))")
//    execution表达式的最全内容这里表示在 包com.springboot.live_comm.annotation.controller下的 所有类的 所有public(若不规定修饰符则不写)类型的方法 请求参数任意，返回类型任意aaa，不论是否抛出异常
    public void pointcutForExecution() {
//         * com.springboot.live_comm.annotation.controller.*.*(..))
//        表示在 包com.springboot.live_comm.annotation.controller下的 所有类的 所有的方法
//        * com.*.*(..))
//        表示在 包com下的 所有类的 所有的方法
//        * com.*.executionMethod1(..))
//        表示在 包com下的 所有类的 方法名称为executionMethod1的方法
//        * com.*.*executionMethod*(..))
//        表示在 包com下的 所有类的 方法名称包含executionMethod的方法
//        * com..*Controller*.*(..))
//        表示在 包com下的 所有类名称包含Controller的所有方法
//        * com..*Controller*.*(..)) *
//        表示在 包com下的 所有类名称包含Controller的所有方法 接口必须抛出了异常

    }
//            -------网上的原文-----
//    任意公共方法的执行：execution(public * *(..))
//    任何一个以“set”开始的方法的执行：execution(* set*(..))
//    AccountService 接口的任意方法的执行：execution(* com.xyz.service.AccountService.*(..))
//    定义在service包里的任意方法的执行： execution(* com.xyz.service.*.*(..))
//    定义在service包和所有子包里的任意类的任意方法的执行：execution(* com.xyz.service..*.*(..))
//    第一个*表示匹配任意的方法返回值， ..(两个点)表示零个或多个，第一个..表示service包及其子包,第二个*表示所有类, 第三个*表示所有方法，第二个..表示方法的任意参数个数
//    定义在pointcutexp包和所有子包里的JoinPointObjP2类的任意方法的执行：execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")
//            -------网上的原文-----


    @Pointcut("within (com.springboot.live_comm.annotation.controller.ControllerForWithin)")
//    等于 execution(public * com.springboot.live_comm.annotation.controller.ControllerForWithin.*(..))
//    com.springboot.live_comm.annotation.controller.ControllerForWithin类中所有public的方法
    public void pointcutForWithin() {
//within的特点是可以指向子包
    }
    //            -------网上的原文-----
    //    pointcutexp包里的任意类的任意public的方法： within(com.test.spring.aop.pointcutexp.*)
    //    pointcutexp包和所有子包里的任意类的任意public的方法：within(com.test.spring.aop.pointcutexp..*)
    //            -------网上的原文-----


    @Pointcut("this (com.springboot.live_comm.annotation.interfaces.Action)")
    public void pointcutForThis() {
//within的特点是可以指向接口，指向接口时，接口的实现都会被AOP
    }

    //            -------网上的原文-----
//    实现了Intf接口的所有类,如果Intf不是接口,限定Intf单个类：this(com.test.spring.aop.pointcutexp.Intf)
//    当一个实现了接口的类被AOP的时候,用getBean方法必须cast为接口类型,不能为该类的类型
    //            -------网上的原文-----
    //    打印请求参数
    @Before("pointcutForExecution()")
    public void aspectForExecution() {
        log.info("aspectForExecution");
    }

    //    打印请求参数
    @Before("pointcutForWithin()")
    public void aspectForWithin() {
        log.info("aspectForWithin");
    }

    //    打印请求参数
    @Before("pointcutForThis()")
    public void aspectForThis() {
        log.info("aspectForThis");
    }
    //    within：用于匹配指定类型内的方法执行；


//-------------------指向类中方法---------------------

    //-------------------指向使用了特定注解的方法---------------------
    @Pointcut("@annotation(com.springboot.live_comm.annotation.interfaces.InterfaceForAnnotation)")
    public void pointcutForAnnotation() {
//        标注了@InterfaceForAnnotation的public的方法
    }

    @Before("pointcutForAnnotation()")
    public void aspectForAnnotation() {
        log.info("aspectForAnnotation");
    }

    @Pointcut("@within(com.springboot.live_comm.annotation.interfaces.InterfaceForWithX)")
//    @Pointcut("@target(com.springboot.live_comm.annotation.interfaces.InterfaceForWithX)")
    public void pointcutForWithinX() {
//        标注了@InterfaceForAnnotation的public的方法
    }

    @Before("pointcutForWithinX()")
    public void aspectForWithinX() {
        log.info("pointcutForWithinX");
    }
//-------------------指向使用了特定注解的方法---------------------


//    //-------------------指向使用了特定参数的方法---------------------
//    @Pointcut("@args(com.springboot.live_comm.annotation.interfaces.InterfaceForArgsX)")
//    public void pointcutForArgsX() {
////    参数带有@InterfaceForWithX标注的方法：
//    }
//
//    @Before("pointcutForArgsX()")
//    public void aspectForArgsX() {
//        log.info("pointcutForArgsX");
//    }
//
//    @Pointcut("args(String)")
//    public void pointcutForArgs() {
////    参数为String类型(运行是决定)的方法： args(String)
//    }
//
//    @Before("pointcutForArgs()")
//    public void aspectForArgs() {
//        log.info("pointcutForArgs");
//    }

//-------------------指向使用了特定参数的方法---------------------


}
