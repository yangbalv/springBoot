package com.springboot.live_comm.tencentcloud.dto;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 人脸识别接受结果的接口的接受参数的Dto
 * code	人脸核身结果的返回码 0：人脸核身成功 其他错误码：失败	String	-
 * orderNo	订单号 ，本次人脸核身上送的订单号	String	32
 * h5faceId	本次请求返回的唯一标识，此信息为本次人脸核身上送的信息	String	32
 * newSignature	对 URL 参数 App ID、orderNo 和 SIGN ticket、code 的签名	String	40
 */
public class TencentCloudStartH5FaceCoreResponseDto {
    private String code;
    private String orderNo;
    private String h5faceId;
    private String newSignature;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getNewSignature() {
        return newSignature;
    }

    public void setNewSignature(String newSignature) {
        this.newSignature = newSignature;
    }

    @Override
    public String toString() {
        return "StartH5FaceCoreResponseDto{" +
                "code='" + code + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", h5faceId='" + h5faceId + '\'' +
                ", newSignature='" + newSignature + '\'' +
                '}';
    }
}
