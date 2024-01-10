package com.springboot.live_comm.controller.dh;

/**
 * @ClassName: SystemEnums
 * @Author : ever
 * @Date :2024/1/4  15:53
 * @Description: TODO
 * @Version :1.0
 */
public enum SystemEnums {
    bizcore("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-bizcore", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-bizcore"),
    bpm("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-bpm", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-bpm"),
    crm("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-crm", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-crm"),
    ecif("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-ecif", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-ecif"),
    erp("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-erp", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-erp"),
    extra("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-extra", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-extra"),
    gateway_cos("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-gateway-cos", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-gateway-cos"),
    gateway_mos("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-gateway-mos", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-gateway-mos"),
    mall("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-mall", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-mall"),
    mds("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-mds", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-mds"),
    mgr("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-mgr", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-mgr"),
    pss("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-pss", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-pss"),
    rcm("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-rcm", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-rcm"),
    sys("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-sys", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-sys"),
    timeservice("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-timeservice", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-timeservice"),
    user("/view/dhbailian-publish/job/dhbailian-publish-dhbailian-user", "/view/dhbailian-deploy/job/dhbailian-deploy-dhbailian-user"),
    contract("/view/dhbailian-publish/job/dhbailian-publish-everlink-contract", "/view/dhbailian-deploy/job/dhbailian-deploy-everlink-contract"),
    service_manager("/view/dhbailian-publish/job/dhbailian-publish-everlink-service-manager", "/view/dhbailian-deploy/job/dhbailian-deploy-everlink-service-manager");

    public String getPublish() {
        return publish;
    }

    public String getDeploy() {
        return deploy;
    }

    private final String publish;
    private final String deploy;

    SystemEnums(String publish, String deploy) {
        this.publish = publish;
        this.deploy = deploy;
    }
}
