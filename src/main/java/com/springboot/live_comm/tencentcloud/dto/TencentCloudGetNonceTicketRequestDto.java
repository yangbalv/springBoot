package com.springboot.live_comm.tencentcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 使用腾讯云人脸核身的时候获取nonce型ticket的发送请求的dto
 * 参数	说明	类型	长度（字节）	是否必填
 * app_id	业务流程唯一标识，即 wbappid，可参考 获取 WBappid 指引在人脸核身控制台内申请	String	8	是
 * access_token	请根据 Access Token 获取 指引进行获取	String	64	是
 * type	ticket 类型，默认值：NONCE（必须大写）	String	20	是
 * version	版本号	String	20	是
 * user_id	当前使用用户的唯一标识，需合作伙伴自行定义
 * 注意：合作伙伴必须保证 user_id 的全局唯一性，不要带有特殊字符
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudGetNonceTicketRequestDto {

    private String app_id;

    private String access_token;

    private String type;

    private String version;

    private String user_id;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getApi_ticketUrl() {
        return api_ticketUrl;
    }

    public void setApi_ticketUrl(String api_ticketUrl) {
        this.api_ticketUrl = api_ticketUrl;
    }

    public TencentCloudGetNonceTicketRequestDto() {
    }
    public TencentCloudGetNonceTicketRequestDto(String app_id, String access_token, String type, String version, String user_id) {
        this.app_id = app_id;
        this.access_token = access_token;
        this.type = type;
        this.version = version;
        this.user_id = user_id;
    }
}
