package com.springboot.personalLearning.threads.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class CountDownController {
    static String countdown = "";
 
    public static void main(String[] args) {
        //开启倒计时
        time();
        System.out.println("Countdown=" + countdown);
    }
 
    /**
     * 倒计时,设定时间戳
     */
    private static void time() {
        Calendar c = Calendar.getInstance();
        // 根据自己的需求进行加/减（年、月、日、时、分、秒），例如：当前日期的下一个月的当前日期：(c.get(Calendar.MONTH) + 1)
        c.set(c.get(Calendar.YEAR), (c.get(Calendar.MONTH)), c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND)+10);// 注意月份的设置，0-11表示1-12月
        // 结束日期
        long endTime = c.getTimeInMillis();
        System.out.println("结束的时间："+ endTime);
        // 查看结束日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        try {
            Date date = sdf.parse(sdf.format(endTime));
            System.out.println("结束日期：" + sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 当前日期
        Date date = new Date();
        long startTime = date.getTime();
        System.out.println("开始日期："+ sdf.format(date));
        System.out.println("开始的时间："+ startTime);
 
        // 计算后的日期时间
        long midTime = (endTime - startTime) / 1000;
        System.out.println("计算后的时间："+ midTime);
 
        // 倒计时处理
        while (midTime > 0) {
            // 打印倒计时
            printCountDown(midTime);
            midTime--;
        }
        // 打印倒计时
        printCountDown(midTime);
    }
 
    /**
     * 打印倒计时
     * @param midTime 时间
     */
    private static void printCountDown(long midTime){
        long dd = midTime / 60 / 60 / 24 % 60;
        long hh = midTime / 60 / 60 % 60;
        long mm = midTime / 60 % 60;
        long ss = midTime % 60;
        System.out.println("还剩" + dd + "天" + hh + "小时" + mm + "分钟" + ss + "秒");
        System.out.println(dd + "" + hh + "" + mm + "" + ss + "");
        countdown = hh + "" + mm + "" + ss + "";
        try {
            // 倒计时每秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}