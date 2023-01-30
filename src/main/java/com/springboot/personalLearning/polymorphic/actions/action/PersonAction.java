package com.springboot.personalLearning.polymorphic.actions.action;

public interface PersonAction {
    //    接口中的常量默认是且必须是public static final的
    public static final int length = 1;

    //    接口中的方法默认是且必须是public abstract的(静态方法除外)
    void talk();

    //    接口中的静态方法与类中的静态方法使用起来一样，不需要重写，可以直接执行方法；
    static void personAction() {
        System.out.println("personAction接口中的静态方法");
    }
}
