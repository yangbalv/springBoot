package com.springboot.live_comm.tencentcloud.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TencentCloudProperties {
    //    腾讯云的sdk/h5服务的业务的id
    @Value("${tencentCloud.h5FaceCore.webankAppId}")
    private String webankAppId;
    //    业务Id对应的密钥
    @Value("${tencentCloud.h5FaceCore.secret}")
    private String secret;

    @Value("${tencentCloud.h5FaceCore.grant_type}")
    private String grant_type;

    @Value("${tencentCloud.h5FaceCore.sourcePhotoStr}")
    private String sourcePhotoStr;

    @Value("${tencentCloud.h5FaceCore.sourcePhotoType}")
    private String sourcePhotoType;

    @Value("${tencentCloud.h5FaceCore.version}")
    private String version;

    @Value("${tencentCloud.h5FaceCore.SIGN_TYPE}")
    private String SIGN_TYPE;

    @Value("${tencentCloud.h5FaceCore.NONCE_TYPE}")
    private String NONCE_TYPE;

    //    回调我们的接口
    @Value("${tencentCloud.h5FaceCore.url}")
    private String url;


    //    结果显示的状态
    @Value("${tencentCloud.h5FaceCore.resultType}")
    private String resultType;

    @Value("${tencentCloud.h5FaceCore.from}")
    private String from;

    @Value("${tencentCloud.h5FaceCore.redirectType}")
    private String redirectType;

    //    上送用户信息时调用的腾讯云的url
    @Value("${tencentCloud.h5FaceCore.getH5FaceIdUrl}")
    private String getH5FaceIdUrl;

    //    获取accesstoken时的腾讯云的url
    @Value("${tencentCloud.h5FaceCore.access_tokenUrl}")
    private String access_tokenUrl;

    //    获取api_ticket时的腾讯云的url
    @Value("${tencentCloud.h5FaceCore.api_ticketUrl}")
    private String api_ticketUrl;

    //    获取人脸核身结果时的腾讯云的url
    @Value("${tencentCloud.h5FaceCore.getH5CoreResultUrl}")
    private String getH5CoreResultUrl;

    //    获取人脸核身结果时的返回结果的方式
    @Value("${tencentCloud.h5FaceCore.get_file}")
    private String get_file;

    public String getWebankAppId() {
        return webankAppId;
    }

    public void setWebankAppId(String webankAppId) {
        this.webankAppId = webankAppId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSIGN_TYPE() {
        return SIGN_TYPE;
    }

    public void setSIGN_TYPE(String SIGN_TYPE) {
        this.SIGN_TYPE = SIGN_TYPE;
    }

    public String getNONCE_TYPE() {
        return NONCE_TYPE;
    }

    public void setNONCE_TYPE(String NONCE_TYPE) {
        this.NONCE_TYPE = NONCE_TYPE;
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

    public String getGetH5FaceIdUrl() {
        return getH5FaceIdUrl;
    }

    public void setGetH5FaceIdUrl(String getH5FaceIdUrl) {
        this.getH5FaceIdUrl = getH5FaceIdUrl;
    }

    public String getAccess_tokenUrl() {
        return access_tokenUrl;
    }

    public void setAccess_tokenUrl(String access_tokenUrl) {
        this.access_tokenUrl = access_tokenUrl;
    }

    public String getApi_ticketUrl() {
        return api_ticketUrl;
    }


    public void setApi_ticketUrl(String api_ticketUrl) {
        this.api_ticketUrl = api_ticketUrl;
    }

    public String getGetH5CoreResultUrl() {
        return getH5CoreResultUrl;
    }

    public void setGetH5CoreResultUrl(String getH5CoreResultUrl) {
        this.getH5CoreResultUrl = getH5CoreResultUrl;
    }

    public String getGet_file() {
        return get_file;
    }

    public void setGet_file(String get_file) {
        this.get_file = get_file;
    }
}
