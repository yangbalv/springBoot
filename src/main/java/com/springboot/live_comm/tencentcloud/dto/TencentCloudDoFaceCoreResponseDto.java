package com.springboot.live_comm.tencentcloud.dto;

public class TencentCloudDoFaceCoreResponseDto {
    private boolean result;

    private String url;
    private String resultMsg;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return "TencentCloudStartF5FaceCoreResponseDto{" +
                "result=" + result +
                ", url='" + url + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
