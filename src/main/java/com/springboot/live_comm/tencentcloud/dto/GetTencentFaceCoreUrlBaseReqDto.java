package com.springboot.live_comm.tencentcloud.dto;

public class GetTencentFaceCoreUrlBaseReqDto {
    private String name;
    private String idNo;
    //32位随机数
    private String orderNo;
    private String userId;


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


    @Override
    public String toString() {
        return "GetTencentFaceCoreUrlBaseReqDto{" +
                "name='" + name + '\'' +
                ", idNo='" + idNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
