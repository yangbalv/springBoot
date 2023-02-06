package com.springboot.live_comm.services.flashsale;

import com.springboot.live_comm.base.dao.IBaseDao;
import com.springboot.live_comm.base.model.IBaseModel;
import com.springboot.live_comm.base.servise.impl.BaseServiceImpl;
import com.springboot.live_comm.dto.flashsale.FlashSaleResponseDto;
import com.springboot.live_comm.entity.activity.FlashSale;
import com.springboot.live_comm.mappers.mybatiss1.ActivityManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FlashSaleService extends BaseServiceImpl<FlashSale, Integer, ActivityManageMapper> {
    @Autowired
    private ActivityManageMapper activityManageMapper;

    @Override
    public List<FlashSale> getList(Map<String, Object> param) {
        return null;
    }

    @Override
    public List<FlashSale> getList(FlashSale flashSale) {
        return null;
    }

    @Override
    public ActivityManageMapper getDao() {
        return activityManageMapper;
    }


//    public FlashSale getFlashSale(FlashSale flashSale) {
//        return activityManageMapper.getFlashSale(flashSale);
//    }

    @Transactional(transactionManager = "platformTransactionManagerOne")
    public FlashSaleResponseDto flashSale(FlashSale flashSale) {
        FlashSaleResponseDto flashSaleResponseDto = new FlashSaleResponseDto();
        flashSale = activityManageMapper.getFlashSale(flashSale);
        Integer time = flashSale.getTime();
        if (time <= 0) {
            flashSaleResponseDto.setStatus(001);
            flashSaleResponseDto.setMsg("以抢完");
            return flashSaleResponseDto;
        }
        int i = activityManageMapper.flashSale(flashSale);
        if (i == 1) {
            flashSaleResponseDto.setStatus(time);
            flashSaleResponseDto.setMsg("抢卷成功");
        } else {
            flashSaleResponseDto.setStatus(002);
            flashSaleResponseDto.setMsg("抢卷失败");
        }
        return flashSaleResponseDto;
    }


//    public FlashSale getFlashSalelgs(FlashSale flashSale) {
//        return activityManageMapper.getFlashSalelgs(flashSale);
//    }

    @Transactional(transactionManager = "platformTransactionManagerOne")
    public FlashSaleResponseDto flashSalelgs(FlashSale flashSale) {
        FlashSaleResponseDto flashSaleResponseDto = new FlashSaleResponseDto();
        flashSale = activityManageMapper.getFlashSalelgs(flashSale);
        Integer time = flashSale.getTime();
        if (time <= 0) {
            flashSaleResponseDto.setStatus(001);
            flashSaleResponseDto.setMsg("以抢完");
            return flashSaleResponseDto;
        }
        int i = activityManageMapper.flashSalelgs(flashSale);
        if (i == 1) {
            flashSaleResponseDto.setStatus(time);
            flashSaleResponseDto.setMsg("抢卷成功");
        } else {
            flashSaleResponseDto.setStatus(002);
            flashSaleResponseDto.setMsg("抢卷失败");
        }
        return flashSaleResponseDto;
    }


//    public FlashSale getFlashSalebgs(FlashSale flashSale) {
//        return activityManageMapper.getFlashSalebgs(flashSale);
//    }

    @Transactional(transactionManager = "platformTransactionManagerOne")
    public FlashSaleResponseDto flashSalebgs(FlashSale flashSale) {
        FlashSaleResponseDto flashSaleResponseDto = new FlashSaleResponseDto();
        flashSale = activityManageMapper.getFlashSalebgs(flashSale);
        Integer time = flashSale.getTime();
        if (time <= 0) {
            flashSaleResponseDto.setStatus(-2);
            flashSaleResponseDto.setMsg("以抢完");
            return flashSaleResponseDto;
        }
        int i = activityManageMapper.flashSalebgs(flashSale);
        if (i == 1) {
            flashSaleResponseDto.setStatus(time);
            flashSaleResponseDto.setMsg("抢卷成功");
        } else {
            flashSaleResponseDto.setStatus(-1);
            flashSaleResponseDto.setMsg("抢卷失败");
        }
        return flashSaleResponseDto;
    }

    @Transactional(transactionManager = "platformTransactionManagerOne")
    public FlashSaleResponseDto flashSalebgs2(FlashSale flashSale) {
        FlashSaleResponseDto flashSaleResponseDto = new FlashSaleResponseDto();
        flashSale = activityManageMapper.getFlashSalebgs(flashSale);
        Integer time = flashSale.getTime();
        if (time <= 0) {
            flashSaleResponseDto.setStatus(-2);
            flashSaleResponseDto.setMsg("以抢完");
            return flashSaleResponseDto;
        }
        int i = activityManageMapper.flashSalebgs(flashSale);
        if (i == 1) {
            flashSaleResponseDto.setStatus(time);
            flashSaleResponseDto.setMsg("抢卷成功");
        } else {
            flashSaleResponseDto.setStatus(-1);
            flashSaleResponseDto.setMsg("抢卷失败");
        }
        int x = 1 / 0;
        return flashSaleResponseDto;
    }


    synchronized public FlashSaleResponseDto flashSale2(FlashSale flashSale) {
        FlashSaleResponseDto flashSaleResponseDto = new FlashSaleResponseDto();
        flashSale = activityManageMapper.getFlashSale(flashSale);
        Integer time = flashSale.getTime();
        if (time <= 0) {
            flashSaleResponseDto.setStatus(001);
            flashSaleResponseDto.setMsg("以抢完");
            return flashSaleResponseDto;
        }
        int i = activityManageMapper.flashSale(flashSale);
        if (i == 1) {
            flashSaleResponseDto.setStatus(time);
            flashSaleResponseDto.setMsg("抢卷成功");
        } else {
            flashSaleResponseDto.setStatus(002);
            flashSaleResponseDto.setMsg("抢卷失败");
        }
        return flashSaleResponseDto;
    }
}
