package com.springboot.live_comm.annotation.testbymain;

 
import com.springboot.live_comm.annotation.interfaces.MyAnnotation;
import com.springboot.live_comm.annotation.controller.TestAspectController;

import java.lang.annotation.Annotation;
 
public class Test {
    public static void main(String[] args) {

        for (Annotation a : TestAspectController.class.getAnnotations()) {
            /*
            *
            * 判断里面的注解是否在类上面
            * */
//            System.out.println(a);
 
            /*
            * 判断遍历出来的注解是否属于某个注解
            * */
            if(a instanceof MyAnnotation){
                System.out.println(((MyAnnotation) a).message());
            }
        }
 
 
         MyAnnotation a = TestAspectController.class.getAnnotation(MyAnnotation.class);
        if(a!=null){
            System.out.println(a.message());
 
        }
    }
}