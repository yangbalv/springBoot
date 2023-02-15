package com.springboot.live_comm.utils;

import com.springboot.live_comm.entity.activity.FlashSale;

/**
 * 字符串操作工具类
 */
public class XStringUtil {


    public static void main(String[] args) {
        XStringUtil.toLowerCase("SHOP_NAME");
    }

    //    ABC_BFD_AAA  --->abcBfdAaa
    public static void toLowerCase(String req) {
        String upcase = req;
        String lowerCase = upcase.toLowerCase();
        String[] strings = lowerCase.split("_");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {

            String s = strings[i];
            if (i > 0) {
                s = "" + (Character.toUpperCase(s.charAt(0))) + s.substring(1);
            }
            stringBuilder.append(s);
        }

        System.out.println(stringBuilder);
    }
}
