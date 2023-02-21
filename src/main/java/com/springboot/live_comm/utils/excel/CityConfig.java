package com.springboot.live_comm.utils.excel;

import com.springboot.live_comm.base.model.impl.BaseModelAdapter;

public class CityConfig extends BaseModelAdapter<String> {
//    private Integer cityId;
    private String parentId;
    private String name;
    private String type;

//    public Integer getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(Integer cityId) {
//        this.cityId = cityId;
//    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
