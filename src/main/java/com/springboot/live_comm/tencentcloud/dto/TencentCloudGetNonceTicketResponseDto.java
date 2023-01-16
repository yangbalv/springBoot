package com.springboot.live_comm.tencentcloud.dto;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 使用腾讯云人脸核身的时候获取nonce型ticket的接受结果的dto
 * code	String	0：成功
 * 非0：失败
 * 详情请参见 SaaS 服务错误码
 * msg	String	请求结果描述
 * transactionTime	String	调用接口的时间
 * tickets	list	ticket 返回数组
 * value	String	ticket 的值
 * expire_time	String	ticket 失效的绝对时间
 * expire_in	int	ticket 的最大生存时间
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TencentCloudGetNonceTicketResponseDto {
    private String code;
    private String msg;
    private String transactionTime;
    private List<JSONObject> tickets;
    private String ticket;
    private String value;
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

    public List<JSONObject> getTickets() {
        return tickets;
    }

    public void setTickets(List<JSONObject> tickets) {
        this.tickets = tickets;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public void reload() {
        JSONObject nonceTicketJson = tickets.get(0);
        ticket = (String) nonceTicketJson.get("value");
        expire_in = (int) nonceTicketJson.get("expire_in");
        expire_time = (String) nonceTicketJson.get("expire_time");

    }

    @Override
    public String toString() {
        return "GetNonceTicketResponseDto{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                ", tickets=" + tickets +
                ", ticket='" + ticket + '\'' +
                ", value='" + value + '\'' +
                ", expire_time='" + expire_time + '\'' +
                ", expire_in=" + expire_in +
                '}';
    }
}
