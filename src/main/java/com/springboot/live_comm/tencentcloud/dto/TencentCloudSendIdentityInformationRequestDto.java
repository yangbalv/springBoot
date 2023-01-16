package com.springboot.live_comm.tencentcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 上送身份信息时发送请求的Dto
 * webankAppId	业务流程唯一标识，即 wbappid，可参考 获取 WBappid 指引在人脸核身控制台内申请	String	8	是
 * orderNo	订单号，字母/数字组成的字符串，由合作方上送，每次唯一，不能超过32位	String	不能超过32位	是
 * name	姓名	String	-	使用权威源比对时：姓名+证件号 必须输入 使用自带源比对时：姓名+证件号 可不输入
 * idNo	证件号码	String	-	使用权威源比对时：姓名+证件号 必须输入 使用自带源比对时：姓名+证件号 可不输入
 * userId	用户 ID ，用户的唯一标识（不能带有特殊字符），需要跟生成签名的 userId 保持一致	String	不能超过32位	是
 * sourcePhotoStr	比对源照片，注意：原始图片不能超过500KB，且必须为 JPG 或 PNG、BMP 格式 参数有值：使用合作伙伴提供的比对源照片进行比对，必须注照片是正脸可信照片，照片质量由合作方保证 参数为空 ：根据身份证号+姓名使用权威数据源比对 Base64 String	1048576	否 请使用标准的图片转base64方法，base64编码不可包含换行符，不需要加前缀
 * sourcePhotoType	比对源照片类型，注意： 如合作方上送比对源则必传，使用权威数据源可不传 参数值为1：水纹正脸照 参数值为2：高清正脸照 重要提示：照片上无水波纹的为高清照，请勿传错，否则影响比对准确率。如有疑问，请联系腾讯云技术支持线下确认 String	1	否，提供比对源照片需要传
 * version	默认参数值为：1.0.0	String	20	是
 * sign	签名：使用上文 生成的签名	String	40
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudSendIdentityInformationRequestDto {
    private String webankAppId;
    private String orderNo;
    private String name;
    private String idNo;
    private String userId;
    private String sourcePhotoStr;
    private String sourcePhotoType;
    private String version;
    private String sign;
    private String getH5FaceIdUrl;

    public String getWebankAppId() {
        return webankAppId;
    }

    public void setWebankAppId(String webankAppId) {
        this.webankAppId = webankAppId;
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

//    public String getSourcePhotoStr() {
//        return sourcePhotoStr;
//    }
//
//    public void setSourcePhotoStr(String sourcePhotoStr) {
//        this.sourcePhotoStr = sourcePhotoStr;
//    }
//
//    public String getSourcePhotoType() {
//        return sourcePhotoType;
//    }
//
//    public void setSourcePhotoType(String sourcePhotoType) {
//        this.sourcePhotoType = sourcePhotoType;
//    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSourcePhotoStr() {
        return sourcePhotoStr;
    }

    public void setSourcePhotoStr(String sourcePhotoStr) {
        this.sourcePhotoStr = sourcePhotoStr;
    }

    public String getSourcePhotoType() {
        return sourcePhotoType;
    }

    public void setSourcePhotoType(String sourcePhotoType) {
        this.sourcePhotoType = sourcePhotoType;
    }

    public String getGetH5FaceIdUrl() {
        return getH5FaceIdUrl;
    }

    public void setGetH5FaceIdUrl(String getH5FaceIdUrl) {
        this.getH5FaceIdUrl = getH5FaceIdUrl;
    }

    public TencentCloudSendIdentityInformationRequestDto() {
    }

    public TencentCloudSendIdentityInformationRequestDto(String webankAppId, String orderNo, String name, String idNo, String userId, String version, String sign) {
        this.webankAppId = webankAppId;
        this.orderNo = orderNo;
        this.name = name;
        this.idNo = idNo;
        this.userId = userId;
        this.version = version;
        this.sign = sign;
    }

    public TencentCloudSendIdentityInformationRequestDto(String webankAppId, String orderNo, String name, String idNo, String userId, String sourcePhotoStr, String sourcePhotoType, String version, String sign) {
        this.webankAppId = webankAppId;
        this.orderNo = orderNo;
        this.name = name;
        this.idNo = idNo;
        this.userId = userId;
//        this.sourcePhotoStr = sourcePhotoStr;
//        this.sourcePhotoType = sourcePhotoType;
        this.version = version;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "TencentCloudSendIdentityInformationRequestDto{" +
                "webankAppId='" + webankAppId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", name='" + name + '\'' +
                ", idNo='" + idNo + '\'' +
                ", userId='" + userId + '\'' +
                ", sourcePhotoStr='" + sourcePhotoStr + '\'' +
                ", sourcePhotoType='" + sourcePhotoType + '\'' +
                ", version='" + version + '\'' +
                ", sign='" + sign + '\'' +
                ", getH5FaceIdUrl='" + getH5FaceIdUrl + '\'' +
                '}';
    }
}
