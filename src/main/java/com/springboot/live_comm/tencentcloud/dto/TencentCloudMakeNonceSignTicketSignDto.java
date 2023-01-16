package com.springboot.live_comm.tencentcloud.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangtianyi
 * @version 1.0.0
 * @since 2022.01.18
 * 上传人物信息时需要的 nonceticnke生成的sign 需要的信息
 * 参数	说明	来源
 * wbappid	业务流程唯一标识	参考 获取 WBappid 指引在人脸核身控制台内申请
 * orderNo	订单号，字母/数字组成的字符串，本次人脸核身合作伙伴上送的订单号，唯一标识	合作方自行分配，不要带有特殊字符
 * userId	用户 ID，用户的唯一标识（不要带有特殊字符）	合作方自行分配（与接口中使用的 userId 保持一致，不要带有特殊字符）
 * version	参数值为：1.0.0	-
 * h5faceId	h5/geth5faceid 接口返回的唯一标识	-
 * api ticket	合作伙伴服务端实时获取的 tikcet，注意是 NONCE 类型	获取方式请参见 获取 NONCE ticket（所用的 userId 与接口里定义的 userId 参数值保持一致）
 * nonce	随机数：32位随机串（字母+数字组成的随机数）	合作方自行生成（与接口中定义的随机数保持一致，不要带有特殊字符）
 */

public class TencentCloudMakeNonceSignTicketSignDto {

    private String wbappid;
    private String orderNo;
    private String userId;
    private String version;
    private String h5faceId;
    private String apiticket;
    private String nonce;

    public String getWbappid() {
        return wbappid;
    }

    public void setWbappid(String wbappid) {
        this.wbappid = wbappid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getH5faceId() {
        return h5faceId;
    }

    public void setH5faceId(String h5faceId) {
        this.h5faceId = h5faceId;
    }

    public String getApiticket() {
        return apiticket;
    }

    public void setApiticket(String apiticket) {
        this.apiticket = apiticket;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public TencentCloudMakeNonceSignTicketSignDto() {
    }

    public TencentCloudMakeNonceSignTicketSignDto(String wbappid, String orderNo, String userId, String version, String h5faceId, String apiticket, String nonce) {
        this.wbappid = wbappid;
        this.orderNo = orderNo;
        this.userId = userId;
        this.version = version;
        this.h5faceId = h5faceId;
        this.apiticket = apiticket;
        this.nonce = nonce;

    }

    public List toList() {
        List<String> signTicketList = new ArrayList<String>();
        signTicketList.add(wbappid);
        signTicketList.add(orderNo);
        signTicketList.add(userId);
        signTicketList.add(version);
        signTicketList.add(h5faceId);
        signTicketList.add(nonce);
        return signTicketList;
    }
}
