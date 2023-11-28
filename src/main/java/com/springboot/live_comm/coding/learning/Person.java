package com.springboot.live_comm.coding.learning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    // 属性
    private String name;
    private int age;
    private String gender;
    private String occupation;  // 职业
    private Date birthDate;  // 出生日期
    private String educationLevel;  // 教育程度
    private String address;  // 地址
    private String phoneNumber;  // 电话号码
    private String email;  // 邮箱
    private Date birthday;  // 生日
    private String nationality;  // 国籍
    private String website;  // 个人网站
    private String bloodType;  // 血型
    private int height;  // 身高

    // 判断是否为成年人的方法
    public boolean isAdult() {
        return age >= 18;
    }

    // 判断是否为未成年人的方法
    public boolean isMinor() {
        return age < 18;
    }

    // 根据生日计算星座的方法
    public String getZodiacSign() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (month == 1 && day >= 20 || month == 2 && day <= 18) {
            return "水瓶座";
        } else if (month == 2 && day >= 19 || month == 3 && day <= 20) {
            return "双鱼座";
        } else if (month == 3 && day >= 21 || month == 4 && day <= 19) {
            return "白羊座";
        } else if (month == 4 && day >= 20 || month == 5 && day <= 20) {
            return "金牛座";
        } else if (month == 5 && day >= 21 || month == 6 && day <= 21) {
            return "双子座";
        } else if (month == 6 && day >= 22 || month == 7 && day <= 22) {
            return "巨蟹座";
        } else if (month == 7 && day >= 23 || month == 8 && day <= 22) {
            return "狮子座";
        } else if (month == 8 && day >= 23 || month == 9 && day <= 22) {
            return "处女座";
        } else if (month == 9 && day >= 23 || month == 10 && day <= 23) {
            return "天秤座";
        } else if (month == 10 && day >= 24 || month == 11 && day <= 22) {
            return "天蝎座";
        } else if (month == 11 && day >= 23 || month == 12 && day <= 21) {
            return "射手座";
        } else {
            return "摩羯座";
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}