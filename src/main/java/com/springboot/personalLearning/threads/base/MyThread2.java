package com.springboot.personalLearning.threads.base;


import com.springboot.live_comm.utils.HttpUtil;

import java.io.IOException;

public class MyThread2 extends Thread {
    String name;

    MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        HttpUtil httpUtil = new HttpUtil();


        try {
            System.out.println(name + "---" + httpUtil.getHTML("http://192.168.3.64:8090/zty/test/doFlashSalebgs?orderName=" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
