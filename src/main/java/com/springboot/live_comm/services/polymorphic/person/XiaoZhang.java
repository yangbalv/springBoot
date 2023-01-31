package com.springboot.live_comm.services.polymorphic.person;

import com.springboot.live_comm.services.polymorphic.actions.SingerAction;
import com.springboot.live_comm.services.polymorphic.actions.SportAction;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//小张独立实现了SingerAction,SportAction表明他拥有的行为，并且独立声明了自己属性
//由于小张是独立生成的所以小张需要实现所有的接口，代码庸长
@Service
@Primary
public class XiaoZhang implements SingerAction, SportAction {
    public String name;
    public int age;

    @Override
    public void sing(String song) {

    }


    @Override
    public void walk() {

    }

}
