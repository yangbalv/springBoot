package com.springboot.personalLearning.polymorphic.models.abstractmodel;

public abstract class AbstractPerson {
    public String name;
    public int age;

    public abstract void run();

    public void abstractPerson() {
        System.out.println("AbstractPerson抽象类中的方法");
    }
}
