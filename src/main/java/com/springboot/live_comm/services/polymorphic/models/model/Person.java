package com.springboot.live_comm.services.polymorphic.models.model;

import com.springboot.live_comm.services.polymorphic.actions.PersonAction;

public class Person implements PersonAction {
    public String name;
    public int age;

    public void talk() {

    }

//    抽象方法必须放在抽象类中
//public abstract void work();
}
