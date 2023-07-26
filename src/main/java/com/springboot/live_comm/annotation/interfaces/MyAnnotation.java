package com.springboot.live_comm.annotation.interfaces;
 
import java.lang.annotation.*;
 
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
 
    String message() default "aaa";
}