package com.springboot.live_comm.annotation.interfaces;
 
 
import java.lang.annotation.*;
 
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
}