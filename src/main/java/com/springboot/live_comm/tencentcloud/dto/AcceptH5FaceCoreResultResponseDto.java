package com.springboot.live_comm.tencentcloud.dto;//package com.example.dto;

/**
 * 参数	类型	说明
 * code	String	0：身份验证成功且认证为同一人其他返回值详情，请参见 SaaS 服务错误码
 * msg	String	返回结果描述
 * bizSeqNo	String	业务流水号
 * transactionTime	String	请求接口的时间
 * orderNo	String	订单编号
 * idNo	String	证件号码
 * idType	String	证件类型
 * name	String	姓名
 * liveRate	String	活体检测得分
 * similarity	String	人脸比对得分
 * occurredTime	String	进行刷脸的时间
 * photo	Base64 String	人脸核身时的照片，Base64 位编码
 * video	Base64 String	人脸核身时的视频，Base64 位编码
 * app_id	String	腾讯服务分配的 app_id
 */
public class AcceptH5FaceCoreResultResponseDto {

    private String code;
    private String msg;
    private String bizSeqNo;
    private String transactionTime;
    private String orderNo;
    private String idNo;
    private String idType;
    private String name;
    private String liveRate;
    private String similarity;
    private String occurredTime;
    private String photo;
    private String video;
    private String app_id;

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

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLiveRate() {
        return liveRate;
    }

    public void setLiveRate(String liveRate) {
        this.liveRate = liveRate;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }

    public String getOccurredTime() {
        return occurredTime;
    }

    public void setOccurredTime(String occurredTime) {
        this.occurredTime = occurredTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }
}
