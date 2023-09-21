package com.springboot.live_comm.controller.test;

import lombok.Data;

/**
 * @Description: 流程中心回调通知数据接收
 * @Author: nzj
 * @Date: 2023/4/3 14:46
 * @Version: 1.0
 */
@Data
public class ProcessCallbackDto {

    /**
     * 实例ID（流程ID）
     */
    private String instanceId;

    /**
     * 备注/审批意见
     */
    private String remark;

    /**
     * 审批人
     */
    private String approver;

    /**
     * 审批人姓名
     */
    private String approverName;

    /**
     * 审批号
     */
    private String approvalNo;
}
