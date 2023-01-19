package com.springboot.live_comm.configs.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
//        System.out.println(this.getClass().getName() + ">>> requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
//        System.out.println(this.getClass().getName() + ">>> requestInitialized");
    }
}
