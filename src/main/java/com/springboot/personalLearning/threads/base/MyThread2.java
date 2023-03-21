package com.springboot.personalLearning.threads.base;


import com.springboot.live_comm.utils.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MyThread2 extends Thread {
    private static Logger logger = LoggerFactory.getLogger(MyThread2.class);
    String name;

    MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        HttpUtil httpUtil = new HttpUtil();


        try {
            logger.info(name + "---" + httpUtil.getHTML("http://wxtest.allinfinance.com/evercos/creditcard/sns/oauth2"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
