package com.springboot.live_comm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonDateUtil {
    //    字符串转日期
    public Date stringToDate(String dateString, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(dateString);
    }

    public Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(dateString);
    }


    //    日期转字符串

    public String DateToString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public String DateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }


    //    获取到下一个日期的时间(下一个周五10点)
    public static Date getNextMonDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //1-7  1= Sunday
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//        周日为1比周五的6小，单独计算
        if (dayOfWeek == 1) {
            cal.add(Calendar.DATE, 5);
        } else {
//            周五为6
            int disDay = 6 - dayOfWeek;
            int differenceValue = (7 + disDay) % 7;
            cal.add(Calendar.DATE, differenceValue);
        }
//        设置时分秒
        cal.set(Calendar.HOUR_OF_DAY, 10);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        return cal.getTime();
    }
}
