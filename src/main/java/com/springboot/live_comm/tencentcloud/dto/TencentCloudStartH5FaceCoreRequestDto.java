package com.springboot.live_comm.tencentcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 启动人脸识别需要的参数
 * 参数	说明	类型	长度（字节）	是否必填
 * webankAppId	业务流程唯一标识，即 wbappid，可参考 获取 WBappid 指引在人脸核身控制台内申请	String	8	是
 * version	接口版本号，默认参数值：1.0.0	String	20	是
 * nonce	随机数：32位随机串（字母+数字组成的随机数）	String	32	是
 * orderNo	订单号，字母/数字组成的字符串，由合作方上送，每次唯一，此信息为本次人脸核身上送的信息，不能超过32位	String	32	是
 * h5faceId	h5/geth5faceid 接口返回的唯一标识	String	32	是
 * url	H5 人脸核身完成后回调的第三方 URL，需要第三方提供完整 URL 且做 URL Encode 完整 URL Encode 示例： 原 URL 为https://cloud.tencent.com Encode 后为https%3a%2f%2fcloud.tencent.com String	-	是
 * resultType	是否显示结果页面 参数值为“1”：直接跳转到 url 回调地址 null 或其他值：跳转提供的结果页面 String	-	否
 * userId	用户 ID，用户的唯一标识（不要带有特殊字符）	String	-	是
 * sign	签名：使用上文 生成的签名	String	40	是
 * from browser：表示在浏览器启动刷脸 App：表示在 App 里启动刷脸，默认值为 AppString	40	是
 * redirectType	跳转模式，参数值为“1”时，刷脸页面使用 replace 方式跳转，不在浏览器 history 中留下记录；不传或其他值则正常跳转	String	-	否
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudStartH5FaceCoreRequestDto {

    private String webankAppId;

    private String version;

    private String nonce;

    private String orderNo;

    private String h5faceId;

    private String url;

    private String resultType;

    private String userId;

    private String sign;

    private String from;

    private String redirectType;

    public String getWebankAppId() {
        return webankAppId;
    }

    public void setWebankAppId(String webankAppId) {
        this.webankAppId = webankAppId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        this.redirectType = redirectType;
    }

    public TencentCloudStartH5FaceCoreRequestDto() {
    }

    public TencentCloudStartH5FaceCoreRequestDto(String webankAppId, String version, String nonce, String orderNo, String h5faceId, String url, String resultType, String userId, String sign, String from, String redirectType) {
        this.webankAppId = webankAppId;
        this.version = version;
        this.nonce = nonce;
        this.orderNo = orderNo;
        this.h5faceId = h5faceId;
        this.url = url;
        this.resultType = resultType;
        this.userId = userId;
        this.sign = sign;
        this.from = from;
        this.redirectType = redirectType;
    }
}
