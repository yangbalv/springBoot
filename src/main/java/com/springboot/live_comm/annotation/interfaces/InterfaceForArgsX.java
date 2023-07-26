package com.springboot.live_comm.annotation.interfaces;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.TYPE})
@Documented
@Inherited
//@Target是自定义注释时必选的，表示该注解的作用目标。
//@Retention注解也是必选的，表示该注解的保留策略。
//@Documented 注解写入文档 表示注解是否能被 javadoc 处理并保留在文档中。
//@Inherited子类继承父类的注解（子类没有任何注解修饰）
public @interface InterfaceForArgsX {
    //这个default是默认值，不写默认值的注解，在使用时必须添加参数
    public int type() default 0;
}
