package com.springboot.live_comm.controller;

import com.springboot.live_comm.dto.flashsale.FlashSaleResponseDto;
import com.springboot.live_comm.entity.activity.FlashSale;
import com.springboot.live_comm.services.flashsale.FlashSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//秒杀活动测试
@RestController
public class FlashSaleController {
    @Autowired
    private FlashSaleService flashSaleService;

    //不做任何处理的
    @RequestMapping(value = "/test/doFlashSale")
    public FlashSaleResponseDto doFlashSale1(String orderName) throws Exception {

        FlashSale flashSale = new FlashSale();
        flashSale.setActivitycode("flashSale");
        FlashSaleResponseDto flashSaleResponseDto = flashSaleService.flashSale(flashSale);
        System.out.println(flashSaleResponseDto);
        return flashSaleResponseDto;
    }

    @RequestMapping(value = "/test/doFlashSalelgs")
    public FlashSaleResponseDto doFlashSalelgs(String orderName) throws Exception {

        FlashSale flashSale = new FlashSale();
        flashSale.setActivitycode("flashSale");
        FlashSaleResponseDto flashSaleResponseDto = flashSaleService.flashSalelgs(flashSale);
        System.out.println(flashSaleResponseDto);
        return flashSaleResponseDto;
    }

    @RequestMapping(value = "/test/doFlashSalebgs")
    public FlashSaleResponseDto doFlashSalebgs(String orderName) throws Exception {

        FlashSale flashSale = new FlashSale();
        flashSale.setActivitycode("flashSale");
        FlashSaleResponseDto flashSaleResponseDto = flashSaleService.flashSalebgs(flashSale);
        System.out.println(flashSaleResponseDto);
        return flashSaleResponseDto;
    }


    @RequestMapping(value = "/test/doFlashSalebgs2")
    public FlashSaleResponseDto doFlashSalebgs2(String orderName) throws Exception {

        FlashSale flashSale = new FlashSale();
        flashSale.setActivitycode("flashSale");
        FlashSaleResponseDto flashSaleResponseDto = flashSaleService.flashSalebgs2(flashSale);
        System.out.println(flashSaleResponseDto);
        return flashSaleResponseDto;
    }

    @RequestMapping(value = "/test/doFlashSalebgs3")
    public FlashSaleResponseDto doFlashSalebgs3(String orderName) throws Exception {

        FlashSale flashSale = new FlashSale();
        flashSale.setActivitycode("flashSale");
        return flashSaleService.flashSale2(flashSale);
    }

}
