package com.springboot.live_comm.tencentcloud.dto;

public class TencentCloudPressButtonResponseDto {
    private String code;
    private String url;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TencentCloudPressButtonResponseDto{" +
                "code=" + code +
                ", url='" + url + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
