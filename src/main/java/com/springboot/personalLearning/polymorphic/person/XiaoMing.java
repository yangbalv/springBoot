package com.springboot.personalLearning.polymorphic.person;

import com.springboot.personalLearning.polymorphic.actions.action.PersonAction;
import com.springboot.personalLearning.polymorphic.models.model.Person;


public class XiaoMing extends Person implements PersonAction {
    {
        name = "小明";
    }


    @Override
    public void talk() {
        System.out.println("我是" + name + ", 今年" + age + "岁");
    }


    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        xiaoMing.talk();
        PersonAction.personAction();
    }

}
