package com.springboot.live_comm.tencentcloud.dto;



import com.springboot.live_comm.tencentcloud.utils.MakeVideoUtil;

import java.io.InputStream;

public class TencentCloudUploadFileRequestDto {


    /**
     * 文件
     */
    private String file;

    private String applyId;
    private String applyName;




    private String originalFilename;

    //    文件的inputStream流
    private InputStream inputStream;

    /**
     * 文件类型（image、video···）
     */
    private String fileType = "video";


    /**
     * 文件业务类型 （DFC、MFC～）
     */
    private String businessType;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public void stringToInputStream() {
//        工具类将字符串转换成流文件
        inputStream = MakeVideoUtil.stringToInputStream(file);
    }
}
