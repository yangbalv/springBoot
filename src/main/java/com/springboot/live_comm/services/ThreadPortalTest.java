package com.springboot.live_comm.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ThreadPortalTest
 * @Author : ever
 * @Date :2023/12/8  11:34
 * @Description: TODO
 * @Version :1.0
 */
public class ThreadPortalTest {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 提交任务给线程池执行
        for (int i = 0; i < 50; i++) {
            executorService.execute(new Task());
        }

        // 关闭线程池（平滑关闭，会执行完正在执行的任务）
        executorService.shutdown();
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("执行任务：" + Thread.currentThread().getName());
    }
}
