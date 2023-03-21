package com.springboot.personalLearning.threads.base;


import com.springboot.live_comm.utils.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MyThread extends Thread {
    private static Logger logger = LoggerFactory.getLogger(MyThread.class);
    String name;

    MyThread(String name) {
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

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            new MyThread("Thread1 +++ " + i).start();
//            new MyThread2("Thread2 +++ " + i).start();
        }
    }

    //    问题描述： 求两个字符串 str1 和 str2 的"最长的"、"公共的"子字符串。
//
//    String str1 = "abc@12345%abcd";
//    String str2 = "abc%12345@abcd";
//
//    预期结果： 输出12345 （因为长度是最长的5， 比abcd 长）。



}
