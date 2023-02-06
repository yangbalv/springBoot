package com.springboot.live_comm.mappers.mybatiss1;

import com.springboot.live_comm.base.dao.IBaseDao;
import com.springboot.live_comm.entity.activity.FlashSale;

public interface ActivityManageMapper extends IBaseDao<FlashSale, Integer> {

    FlashSale getFlashSale(FlashSale flashSale);

    FlashSale getFlashSalelgs(FlashSale flashSale);

    FlashSale getFlashSalebgs(FlashSale flashSale);


    int flashSale(FlashSale flashSale);

    int flashSalelgs(FlashSale flashSale);

    int flashSalebgs(FlashSale flashSale);

}
