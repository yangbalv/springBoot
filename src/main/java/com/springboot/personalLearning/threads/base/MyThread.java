package com.springboot.personalLearning.threads.base;


import com.springboot.live_comm.utils.http.HttpUtil;

import java.io.IOException;

public class MyThread extends Thread {
    String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        HttpUtil httpUtil = new HttpUtil();


        try {
            System.out.println(name + "---" + httpUtil.getHTML("http://localhost/zty/test/doFlashSalelgs?orderName=" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new MyThread("user" + i).start();
//            new MyThread2("userX" + i).start();
        }
    }
}
