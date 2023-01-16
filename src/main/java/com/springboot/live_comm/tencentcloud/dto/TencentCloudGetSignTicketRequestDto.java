package com.springboot.live_comm.tencentcloud.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 使用腾讯云人脸核身的时候获取sign型ticket的发送请求的dto
 * app_id	业务流程唯一标识，即 wbappid，可参考 获取 WBappid 指引在人脸核身控制台内申请	String	8	是
 * access_token	请根据 获取 Access Token 指引进行获取	String	64	是
 * type	ticket 类型，默认值：SIGN（必须大写）	String	20	是
 * version	版本号，默认值：1.0.0	String	20	是
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudGetSignTicketRequestDto {

    private String app_id;

    private String access_token;

    private String type;

    private String version;
    private String api_ticketUrl;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApi_ticketUrl() {
        return api_ticketUrl;
    }

    public void setApi_ticketUrl(String api_ticketUrl) {
        this.api_ticketUrl = api_ticketUrl;
    }

    public TencentCloudGetSignTicketRequestDto(String app_id, String access_token, String type, String version) {
        this.app_id = app_id;
        this.access_token = access_token;
        this.type = type;
        this.version = version;
    }

    public TencentCloudGetSignTicketRequestDto() {
    }

    @Override
    public String toString() {
        return "GetSignTicketRequestDto{" +
                "app_id='" + app_id + '\'' +
                ", access_token='" + access_token + '\'' +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
