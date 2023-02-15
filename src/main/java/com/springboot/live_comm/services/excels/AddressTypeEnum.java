package com.springboot.live_comm.services.excels;

public enum AddressTypeEnum {
    SHENG(1001),
    SHI(1002),
    QU(1003),
    JIEDAO(1004);


    AddressTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }


    private Integer type;

}
