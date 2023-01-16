package com.springboot.live_comm.tencentcloud.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 使用腾讯云人脸核身的时候获取accesstoken的发送请求的dto
 * app_id	业务流程唯一标识，即 wbappid，可参考 获取 WBappid 指引在人脸核身控制台内申请	String	8	是
 * secret	wbappid 对应的密钥，申请 wbappid 时得到，可参考 获取 WBappid 指引在人脸核身控制台内申请	String	64	是
 * grant_type	授权类型，默认值为：client_credential（必须小写）	String	20	是
 * version	版本号，默认值为：1.0.0	String	20	是
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudGetAccessTokenRequestDto {

    private String app_id;

    private String secret;

    private String grant_type;

    private String version;

    private String access_tokenUrl;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAccess_tokenUrl() {
        return access_tokenUrl;
    }

    public void setAccess_tokenUrl(String access_tokenUrl) {
        this.access_tokenUrl = access_tokenUrl;
    }

    public TencentCloudGetAccessTokenRequestDto(String app_id, String secret, String grant_type, String version) {
        this.app_id = app_id;
        this.secret = secret;
        this.grant_type = grant_type;
        this.version = version;
    }

    public TencentCloudGetAccessTokenRequestDto() {
    }

}
