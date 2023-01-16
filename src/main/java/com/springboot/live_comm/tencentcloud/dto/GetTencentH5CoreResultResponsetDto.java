package com.springboot.live_comm.tencentcloud.dto;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * 参数	类型	说明
 * code	String	0：身份验证成功且认证为同一人 其他返回值详情，请参见 SaaS 服务错误码
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
public class GetTencentH5CoreResultResponsetDto {
    //       "code":"0",
//               "msg":"请求成功",
//               "bizSeqNo":"18081020001015300215034200859792",
//               "result":
//
//    {
//        "bizSeqNo":"18081020001015300215034200859792",
//            "transactionTime":"20180810150342",
//            "orderNo":"orderNo19959248596551",
//            "idNo":"** *",
//            "idType":"01",
//            "name":"** *",
//            "video":"** ** **",
//            "photo":"** ** **",
//            "liveRate":"100",
//            "similarity":"95.0",
//            "occurredTime":"20180810150152",
//            "success":false
//    },
//            "transactionTime":"20180810150342",
//            "app_id":"TIDAlsRT",
//            "order_no":"orderNo19959248596551"
    private String code;
    private String msg;
    private String bizSeqNo;
    private JSONObject result;
    private String transactionTime;
    private String orderNo;
    private String idNo;
    private String idType;
    private String name;
    private String video;
    private String photo;
    private String liveRate;
    private String similarity;
    private String occurredTime;
    private String app_id;
    private String order_no;
    private boolean success;

    @Override
    public String toString() {
        return "GetTencentH5CoreResultResponsetDto{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", bizSeqNo='" + bizSeqNo + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", idNo='" + idNo + '\'' +
                ", idType='" + idType + '\'' +
                ", name='" + name + '\'' +
                ", video='" + (StringUtils.isBlank(video) ? (video) : (video.length() > 500 ? (video.substring(0, 100) + video.substring(video.length() - 100, video.length())) : video)) + '\'' +
                ", photo='" + photo + '\'' +
                ", liveRate='" + liveRate + '\'' +
                ", similarity='" + similarity + '\'' +
                ", occurredTime='" + occurredTime + '\'' +
                ", app_id='" + app_id + '\'' +
                ", order_no='" + order_no + '\'' +
                ", success=" + success +
                '}';
    }

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

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void reload() {
        bizSeqNo = (String) result.get("bizSeqNo");
        transactionTime = (String) result.get("transactionTime");
        idNo = (String) result.get("idNo");
        idType = (String) result.get("idType");
        name = (String) result.get("name");
        if (!StringUtils.isBlank((String) result.get("video"))) {
            video = (String) result.get("video");
        }
        if (!StringUtils.isBlank((String) result.get("photo"))) {
            photo = (String) result.get("photo");
        }
        liveRate = (String) result.get("liveRate");
        orderNo = (String) result.get("orderNo");
        order_no = (String) result.get("orderNo");
        similarity = (String) result.get("similarity");
        occurredTime = (String) result.get("occurredTime");
        success = (boolean) result.get("success");
        result = null;
    }

}
