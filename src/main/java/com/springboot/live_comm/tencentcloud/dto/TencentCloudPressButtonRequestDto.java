package com.springboot.live_comm.tencentcloud.dto;

public class TencentCloudPressButtonRequestDto {
    private String name;
//    身份证号码
    private String idNo;
    private String orderNo;
    private String userId;


    private CardActiveApplyQueryData queryData;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public TencentCloudPressButtonRequestDto(String name, String idNo) {
        this.name = name;
        this.idNo = idNo;
    }

    public TencentCloudPressButtonRequestDto() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CardActiveApplyQueryData getQueryData() {
        return queryData;
    }

    public void setQueryData(CardActiveApplyQueryData queryData) {
        this.queryData = queryData;
    }

    @Override
    public String toString() {
        return "TencentCloudPressButtonRequestDto{" +
                "name='" + name + '\'' +
                ", idNo='" + idNo.substring(0, 2) + "********" + idNo.substring(idNo.length() - 3, idNo.length() - 1) + '\'' +
                ", queryData='" + queryData + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
