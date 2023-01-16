package com.springboot.live_comm.tencentcloud.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class CardActiveApplyQueryData {
    private String userId;
    private String productCode;
    private String applyChannel;
    private String promoteCode;
    private String applyTypeNo;
    private String recommPhone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getApplyChannel() {
        return applyChannel;
    }

    public void setApplyChannel(String applyChannel) {
        this.applyChannel = applyChannel;
    }

    public String getPromoteCode() {
        return promoteCode;
    }

    public void setPromoteCode(String promoteCode) {
        this.promoteCode = promoteCode;
    }

    public String getApplyTypeNo() {
        return applyTypeNo;
    }

    public void setApplyTypeNo(String applyTypeNo) {
        this.applyTypeNo = applyTypeNo;
    }

    public String getRecommPhone() {
        return recommPhone;
    }

    public void setRecommPhone(String recommPhone) {
        this.recommPhone = recommPhone;
    }

    @Override
    public String toString() {
        return "CardActiveApplyQueryData{" +
                "userId='" + userId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", applyChannel='" + applyChannel + '\'' +
                ", promoteCode='" + promoteCode + '\'' +
                ", applyTypeNo='" + applyTypeNo + '\'' +
                ", recommPhone='" + recommPhone + '\'' +
                '}';
    }

    public static void main(String[] args) {
        CardActiveApplyQueryData cardActiveApplyQueryData = new CardActiveApplyQueryData();
//        cardActiveApplyQueryData.setApplyChannel();
//        cardActiveApplyQueryData.setApplyTypeNo("a1212");
        cardActiveApplyQueryData.setProductCode("sadwa");
        cardActiveApplyQueryData.setPromoteCode("a1212");
        cardActiveApplyQueryData.setRecommPhone("ada");
        cardActiveApplyQueryData.setUserId("321");
        String s = JSONObject.toJSONString(cardActiveApplyQueryData);
        CardActiveApplyQueryData cardActiveApplyQueryData1 = JSON.toJavaObject(JSON.parseObject(s),CardActiveApplyQueryData.class);

        System.out.println(cardActiveApplyQueryData1);
        System.out.println(JSONObject.toJSONString(cardActiveApplyQueryData));


    }
}
