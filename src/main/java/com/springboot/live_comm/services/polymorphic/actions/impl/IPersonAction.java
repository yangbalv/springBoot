package com.springboot.live_comm.services.polymorphic.actions.impl;

import com.springboot.live_comm.services.polymorphic.actions.PersonAction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Service
public class IPersonAction implements PersonAction {
    @Override
    public void talk() {
        System.out.println("111111111111");
    }
}
