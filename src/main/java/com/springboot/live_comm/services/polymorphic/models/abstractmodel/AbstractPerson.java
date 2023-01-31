package com.springboot.live_comm.services.polymorphic.models.abstractmodel;

import com.springboot.live_comm.services.polymorphic.actions.PersonAction;

public abstract class AbstractPerson implements PersonAction {
    public String name;
    public int age;


    public void aPerson() {
        System.out.println("AbstractPerson抽象类中的常规方法");
    }

    public static void staticPerson() {
        System.out.println("AbstractPerson抽象类中的静态方法");
    }

    //AbstractPerson抽象类中的抽象方法，抽象方法需要重写，且没有实际的内容，抽象方法只能写在抽象类或者接口中
    public abstract void abstractPerson();
}
