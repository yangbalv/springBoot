package com.springboot.live_comm.services.polymorphic.actions.impl;

import com.springboot.live_comm.services.polymorphic.actions.PersonAction;
import org.springframework.stereotype.Service;

@Service
public class IPersonActionx implements PersonAction {

    @Override
    public void talk() {
        System.out.println("22222222222");
    }
}
