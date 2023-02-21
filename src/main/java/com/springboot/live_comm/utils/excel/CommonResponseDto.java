package com.springboot.live_comm.utils.excel;

/**
 * 公共响应DTO
 *
 * @author wukaikai
 * @version 1.0.0
 * @since 1.0, 0
 */
public abstract class CommonResponseDto {

    /** 返回码 */
    private Boolean result;
    /** 返回信息 */
    private String resultMsg;

    public CommonResponseDto() {
        this.result = true;
        this.resultMsg = "请求成功";
    }
    public CommonResponseDto(String errMsg) {
        this.result = false;
        this.resultMsg = errMsg;
    }

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

    /**
     * 使用freemarker渲染响应json时使用
     * @return
     */
    public abstract String getView();

    @Override
    public String toString() {
        return "CommonResponseDto{" +
                "result='" + result + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }


}
