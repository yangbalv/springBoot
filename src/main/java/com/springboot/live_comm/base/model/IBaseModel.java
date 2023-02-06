package com.springboot.live_comm.base.model;

import java.io.Serializable;

public interface IBaseModel<PK extends Serializable> extends Serializable {

    public PK getId();

    public void setId(PK id);

}
