package com.springboot.live_comm.utils;

import com.springboot.live_comm.entity.activity.FlashSale;

/**
 * 字符串操作工具类
 */
public class XStringUtil {


    public static void main(String[] args) {

//        活动海报配置URL	ACTIVITY_POSTER_URL	VARCHAR2(128)	128		FALSE	FALSE	FALSE
//        活动期数	TERM	NUMBER			FALSE	FALSE	FALSE
//        活动图片配置URL	ACTIVITY_PICTURE_URL	VARCHAR2(128)	128		FALSE	FALSE	FALSE
//        海报描述	POSTER_DESCRIPTION	<Undefined>			FALSE	FALSE	FALSE
//        海报名称	POSTER_NAME	<Undefined>			FALSE	FALSE	FALSE
//        创建人	CREATED_BY	NUMBER(6)	6		FALSE	FALSE	FALSE
        XStringUtil.toLowerCase("ACTIVITY_POSTER_URL");
        XStringUtil.toLowerCase("TERM");
        XStringUtil.toLowerCase("ACTIVITY_PICTURE_URL");
        XStringUtil.toLowerCase("POSTER_DESCRIPTION");
        XStringUtil.toLowerCase("POSTER_NAME");
        XStringUtil.toLowerCase("CREATED_BY");
        System.out.println();


//        Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
//        推荐人主键	RECOMM_INFO_ID	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        活动期数	TERM	NUMBER			FALSE	FALSE	FALSE
//        银商侧活动id	SILVER_ID	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        领取结果	RECEICED_RESULT	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        领取状态	RECEICED_STATUS	VARCHAR2(6)	6		FALSE	FALSE	FALSE
//        申请人逻辑卡号	APPLY_CARD_NO	VARCHAR2(32)	32		FALSE	FALSE	FALSE
//        创建时间	CREATE_TIME	TIMESTAMP			FALSE	FALSE	FALSE
//        修改时间	UPDATE_TIME	TIMESTAMP			FALSE	FALSE	FALSE
        XStringUtil.toLowerCase("Code");
        XStringUtil.toLowerCase("RECOMM_INFO_ID");
        XStringUtil.toLowerCase("TERM");
        XStringUtil.toLowerCase("SILVER_ID");
        XStringUtil.toLowerCase("RECEICED_RESULT");
        XStringUtil.toLowerCase("RECEICED_STATUS");
        XStringUtil.toLowerCase("APPLY_CARD_NO");
        System.out.println();
        //        Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
//        ID	ID	VARCHAR2(64)	64		TRUE	FALSE	TRUE
//        商铺名	SHOP_NAME	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        商户编号就是促销码	SHOP_PROMOTION_CODE	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        商户地址	SHOP_ADDRESS	VARCHAR2(256)	256		FALSE	FALSE	FALSE
//        商户营业执照编码	SHOP_BLC	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        商户管理员推荐信息ID	RECOMM_INFO_ID	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        客户经理工号	CUST_MANAGER_NO	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        客户经理手机号	CUST_MANAGER_PHONE	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        客户经理姓名	CUST_MANAGER_NAME	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        活动期数	TERM	NUMBER			FALSE	FALSE	FALSE
//        创建时间	CREATE_TIME	TIMESTAMP			FALSE	FALSE	FALSE
//        修改时间	UPDATE_TIME	TIMESTAMP			FALSE	FALSE	FALSE

        XStringUtil.toLowerCase("SHOP_NAME");
        XStringUtil.toLowerCase("SHOP_PROMOTION_CODE");
        XStringUtil.toLowerCase("SHOP_ADDRESS");
        XStringUtil.toLowerCase("SHOP_BLC");
        XStringUtil.toLowerCase("RECOMM_INFO_ID");
        XStringUtil.toLowerCase("CUST_MANAGER_NO");
        XStringUtil.toLowerCase("CUST_MANAGER_PHONE");
        XStringUtil.toLowerCase("CUST_MANAGER_NAME");
        XStringUtil.toLowerCase("TERM");
        System.out.println();

        //        Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
//        客户经理工号	CUST_MANAGER_NO	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        客户经理手机号	CUST_MANAGER_PHONE	VARCHAR2(64)	64		FALSE	FALSE	FALSE
//        客户经理姓名	CUST_MANAGER_NAME	VARCHAR2(64)	64		FALSE	FALSE	FALSE
        XStringUtil.toLowerCase("CUST_MANAGER_NO");
        XStringUtil.toLowerCase("CUST_MANAGER_PHONE");
        XStringUtil.toLowerCase("CUST_MANAGER_NAME");
        //        Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
//        ID	ID	VARCHAR2(64)	64		TRUE	FALSE	TRUE
//        活动code	CODE	VARCHAR2(64)	64		FALSE	FALSE	TRUE
//        活动期数	TERM	NUMBER			FALSE	FALSE	FALSE
//        期数开始时间	TERM_BEGIN_TIME	TIMESTAMP			FALSE	FALSE	FALSE
//        期数结束时间	TERM_END_TIME	TIMESTAMP			FALSE	FALSE	FALSE
//        奖励领取截止时间	TERM_RECEIVING_END_TIME	TIMESTAMP			FALSE	FALSE	FALSE
//        创建时间	CREATE_TIME	TIMESTAMP			FALSE	FALSE	FALSE
//        更新时间	UPDATE_TIME	TIMESTAMP			FALSE	FALSE	FALSE
//        创建人	CREATED_BY	NUMBER			FALSE	FALSE	FALSE

        XStringUtil.toLowerCase("CODE");
        XStringUtil.toLowerCase("TERM");
        XStringUtil.toLowerCase("TERM_BEGIN_TIME");
        XStringUtil.toLowerCase("TERM_END_TIME");
        XStringUtil.toLowerCase("TERM_RECEIVING_END_TIME");
        XStringUtil.toLowerCase("CREATED_BY");


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
