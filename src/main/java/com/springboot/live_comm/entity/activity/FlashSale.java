package com.springboot.live_comm.entity.activity;

import com.springboot.live_comm.base.model.IBaseModel;

import java.io.Serializable;
import java.util.Date;

public class FlashSale implements Serializable, IBaseModel<Integer> {
    private Integer id;
    private String name;
    private String activitycode;
    private String description;
    private Integer time;
    private Integer version;
    private Date starttime;
    private Date endtime;
    private Boolean enabled;
    private Boolean locked;
    private Date createtime;
    private Date updatetime;

    @Override
    public String toString() {
        return "FlashSale{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activitycode='" + activitycode + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", version=" + version +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivitycode() {
        return activitycode;
    }

    public void setActivitycode(String activitycode) {
        this.activitycode = activitycode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
