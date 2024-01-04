package com.springboot.live_comm.controller.dh;

/**
 * @ClassName: SystemEnums
 * @Author : ever
 * @Date :2024/1/4  15:53
 * @Description: TODO
 * @Version :1.0
 */
public enum SystemEnums {
    bizcore("dhbailian-publish-dhbailian-bizcore"),
    bpm("dhbailian-publish-dhbailian-bpm"),
    crm("dhbailian-publish-dhbailian-crm"),
    ecif("dhbailian-publish-dhbailian-ecif"),
    erp("dhbailian-publish-dhbailian-erp"),
    extra("dhbailian-publish-dhbailian-extra"),
    gateway_cos("dhbailian-publish-dhbailian-gateway-cos"),
    gateway_mos("dhbailian-publish-dhbailian-gateway-mos"),
    mall("dhbailian-publish-dhbailian-mall"),
    mds("dhbailian-publish-dhbailian-mds"),
    mgr("dhbailian-publish-dhbailian-mgr"),
    pss("dhbailian-publish-dhbailian-pss"),
    rcm("dhbailian-publish-dhbailian-rcm"),
    sys("dhbailian-publish-dhbailian-sys"),
    timeservice("dhbailian-publish-dhbailian-timeservice"),
    user("dhbailian-publish-dhbailian-user"),
    contract("dhbailian-publish-everlink-contract"),
    service_manager("dhbailian-publish-everlink-service-manager");

    SystemEnums(String key) {
        this.key = key;
    }

    private final String key;

    public String getKey() {
        return key;
    }
}
