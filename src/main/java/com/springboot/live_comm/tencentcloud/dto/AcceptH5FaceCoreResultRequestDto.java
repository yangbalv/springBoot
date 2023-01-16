package com.springboot.live_comm.tencentcloud.dto;//package com.example.dto;

/**
 * 参数	说明	类型	长度（字节）	是否必填
 * app_id	业务流程唯一标识，即 wbappid，可参考 获取 WBappid 指引在人脸核身控制台内申请	String	8	是
 * version	版本号，默认值：1.0.0	String	20	是
 * nonce	随机数	String	32	是
 * order_no	订单号，字母/数字组成的字符串，合作方订单的唯一标识	String	32	是
 * sign	签名值，使用本文生成的签名	String	40	是 （sign）
 * get_file	是否需要获取人脸识别的视频和文件 值为1：返回视频和照片 值为2：返回照片 值为3：返回视频 其他：不返回	String	1	否
 */
public class AcceptH5FaceCoreResultRequestDto {
    private String app_id;
    private String version;
    private String nonce;
    private String order_no;
    private String sign;
    private String get_file;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getGet_file() {
        return get_file;
    }

    public void setGet_file(String get_file) {
        this.get_file = get_file;
    }
}
