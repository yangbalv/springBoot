package com.springboot.live_comm.dto.user;

public class RegisterResponse {
    private Integer status;
    private String msg;

    public RegisterResponse() {
        status = 200;
        msg = "请求成功";
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
