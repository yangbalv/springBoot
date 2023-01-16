package com.springboot.live_comm.tencentcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 上传人物信息时需要的 signticnke生成的sign 需要的信息
 * wbappid	业务流程唯一标识	参考 获取 WBappid 指引在人脸核身控制台内申请
 * orderNo	订单号，字母/数字组成的字符串，本次人脸核身合作伙伴上送的订单号，唯一标识	合作方自行分配
 * name	姓名	-
 * idNo	证件号码	-
 * userId	用户 ID，用户的唯一标识（不要带有特殊字符）	合作方自行分配
 * version	1.0.0	-
 * api ticket	合作伙伴服务端缓存的 tikcet，注意是 SIGN 类型	获取方式请参见 SIGN ticket 获取
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudMakeSignTicketSignDto {

    private String wbappid;
    private String orderNo;
    private String name;
    private String idNo;
    private String userId;
    private String version = "1.0.0";
    private String apiticket;

    public String getApiticket() {
        return apiticket;
    }

    public void setApiticket(String apiticket) {
        this.apiticket = apiticket;
    }

    public String getWbappid() {
        return wbappid;
    }

    public void setWbappid(String wbappid) {
        this.wbappid = wbappid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public TencentCloudMakeSignTicketSignDto() {
    }

    public TencentCloudMakeSignTicketSignDto(String wbappid, String orderNo, String name, String idNo, String userId, String version, String apiticket) {
        this.wbappid = wbappid;
        this.orderNo = orderNo;
        this.name = name;
        this.idNo = idNo;
        this.userId = userId;
        this.version = version;
    }

    public List toList() {
        List<String> signTicketList = new ArrayList<String>();
        signTicketList.add(wbappid);
        signTicketList.add(orderNo);
        signTicketList.add(name);
        signTicketList.add(idNo);
        signTicketList.add(userId);
        signTicketList.add(version);
        return signTicketList;
    }

    @Override
    public String toString() {
        return "TencentCloudMakeSignTicketSignDto{" +
                "wbappid='" + wbappid + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", name='" + name + '\'' +
                ", idNo='" + idNo + '\'' +
                ", userId='" + userId + '\'' +
                ", version='" + version + '\'' +
                ", apiticket='" + apiticket + '\'' +
                '}';
    }
}
