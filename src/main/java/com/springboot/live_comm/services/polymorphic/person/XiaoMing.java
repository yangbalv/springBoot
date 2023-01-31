package com.springboot.live_comm.services.polymorphic.person;

import com.springboot.live_comm.services.polymorphic.models.abstractmodel.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Service
//@Primary
public class XiaoMing extends Student {

    @Override
    public void talk() {
        System.out.println("我是小明");
    }


    @Override
    public void walk() {
        System.out.println("小明会走路");
    }
}
