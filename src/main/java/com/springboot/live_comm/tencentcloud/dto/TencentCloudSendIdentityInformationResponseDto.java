package com.springboot.live_comm.tencentcloud.dto;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 上送身份信息时接受信息的Dto
 * code	String	0：成功
 * 非0：失败
 * 详情请参见 SaaS 服务错误码
 * msg	String	请求结果描述
 * bizSeqNo	String	请求业务流水号
 * orderNo	String	订单编号
 * h5faceId	String	此次刷脸用户标识
 * transactionTime	String	接口请求的时间
 * optimalDomain	String	启动 H5 人脸核身步骤中调用 login 接口使用的域名
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudSendIdentityInformationResponseDto {
    private String code;
    private String msg;
    private String bizSeqNo;
    private String orderNo;
    private JSONObject result;
    private String h5faceId;
    private String transactionTime;
    private String optimalDomain;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBizSeqNo() {
        return bizSeqNo;
    }

    public void setBizSeqNo(String bizSeqNo) {
        this.bizSeqNo = bizSeqNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getH5faceId() {
        return h5faceId;
    }

    public void setH5faceId(String h5faceId) {
        this.h5faceId = h5faceId;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getOptimalDomain() {
        return optimalDomain;
    }

    public void setOptimalDomain(String optimalDomain) {
        this.optimalDomain = optimalDomain;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    /**
     * 将
     */
    public void reLoad() {
        h5faceId = (String) result.get("h5faceId");
        orderNo = (String) result.get("orderNo");
        optimalDomain = (String) result.get("optimalDomain");
    }

    @Override
    public String toString() {
        return "SendIdentityInformationResponseDto{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", bizSeqNo='" + bizSeqNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", result='" + result + '\'' +
                ", h5faceId='" + h5faceId + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                ", optimalDomain='" + optimalDomain + '\'' +
                '}';
    }
}
