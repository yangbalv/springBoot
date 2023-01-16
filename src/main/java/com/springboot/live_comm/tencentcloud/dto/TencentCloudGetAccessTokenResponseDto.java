package com.springboot.live_comm.tencentcloud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 使用腾讯云人脸核身的时候获取accesstoken的接受结果的dto
 * code	String	0：成功
 * 非0：失败
 * 详情请参见 SaaS 服务错误码
 * msg	String	请求结果描述
 * transactionTime	String	调用接口的时间
 * access_token	String	access_token 的值
 * expire_time	String	access_token 失效的绝对时间
 * expire_in	int	access_token 的最大生存时间
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudGetAccessTokenResponseDto {
    private String code;
    private String msg;
    private String transactionTime;
    private String access_token;
    private String expire_time;
    private int expire_in;

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

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public int getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(int expire_in) {
        this.expire_in = expire_in;
    }

    @Override
    public String toString() {
        return "GetAccessTokenResponseDto{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                ", access_token='" + access_token + '\'' +
                ", expire_time='" + expire_time + '\'' +
                ", expire_in=" + expire_in +
                '}';
    }
}
