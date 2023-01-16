package com.springboot.live_comm.tencentcloud.dto;

import java.io.Serializable;

public class TencentCloudUploadFileResponseDto  implements Serializable {

    /**
     * 文件在FTP路径上的相对路径
     */
    private String fileUrl;

    /**
     * 文件所在资源表中的ID
     */
    private String resourceId;

    private Boolean result;
    /** 返回信息 */
    private String resultMsg;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "TencentCloudUploadFileResponseDto{" +
                "fileUrl='" + fileUrl + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", result=" + result +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
