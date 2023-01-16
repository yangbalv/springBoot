package com.springboot.live_comm.tencentcloud.controller;

import com.alibaba.fastjson.JSONObject;

import com.springboot.live_comm.tencentcloud.TencentCloudH5FaceCoreUtil;
import com.springboot.live_comm.tencentcloud.dto.*;
import com.springboot.live_comm.tencentcloud.exception.ServiceException;
import com.springboot.live_comm.tencentcloud.utils.TencentCloudProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/testProperties")
public class TencentCloudTestController {
    public static Logger logger = LoggerFactory.getLogger(TencentCloudTestController.class);
    @Autowired
    TencentCloudProperties tencentCloudProperties;

    @ResponseBody
    @RequestMapping(value = "/testStartF5", method = RequestMethod.POST)
    public TencentCloudPressButtonResponseDto testStartF5(@RequestBody TencentCloudPressButtonRequestDto tencentCloudPressButtonRequestDto) throws ServiceException {
        TencentCloudH5FaceCoreUtil tencentCloudH5FaceCoreUtil = new TencentCloudH5FaceCoreUtil();
        TencentCloudPressButtonResponseDto tencentCloudPressButtonResponseDto;
        try {
            tencentCloudPressButtonResponseDto = tencentCloudH5FaceCoreUtil.pressButton(tencentCloudPressButtonRequestDto, tencentCloudProperties);
            return tencentCloudPressButtonResponseDto;
        } catch (ServiceException e) {
            throw e;
        }


    }

//    @RequestMapping(value = "/testStartF5New", method = RequestMethod.POST)
//    public String testStartF5New(@RequestBody CardApplyPrecheckRequestDto cardApplyPrecheckRequestDto) {
//
//        return "";
//
//    }

    @ResponseBody
    @RequestMapping(value = "/testAcceptF5Result", method = RequestMethod.GET)
    public String testAcceptF5Result(TencentCloudStartH5FaceCoreResponseDto tencentCloudStartH5FaceCoreResponseDto) {
        logger.info("start to acceptF5Result, and the request is {}", JSONObject.toJSONString(tencentCloudStartH5FaceCoreResponseDto));
        String code = tencentCloudStartH5FaceCoreResponseDto.getCode();
        String orderNo = tencentCloudStartH5FaceCoreResponseDto.getOrderNo();
        String h5faceId = tencentCloudStartH5FaceCoreResponseDto.getH5faceId();
        String newSignature = tencentCloudStartH5FaceCoreResponseDto.getNewSignature();
        // TODO: 2022/2/7  根据oderon去找用户信息，将信息获取到之后重定向页面 


        return tencentCloudStartH5FaceCoreResponseDto.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/testGetF5Result", method = RequestMethod.POST)
    public GetTencentH5CoreResultResponsetDto testGetF5Result(@RequestBody GetTencentH5CoreResultRequestDto getTencentH5CoreResultRequestDto) {
        TencentCloudH5FaceCoreUtil tencentCloudH5FaceCoreUtil = new TencentCloudH5FaceCoreUtil();

        getTencentH5CoreResultRequestDto.setOrder_no(getTencentH5CoreResultRequestDto.getOrder_no());
        GetTencentH5CoreResultResponsetDto getTencentH5CoreResultResponsetDto = null;
        try {
            getTencentH5CoreResultResponsetDto = tencentCloudH5FaceCoreUtil.getTencentH5CoreResult(getTencentH5CoreResultRequestDto, tencentCloudProperties);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        System.out.println(getTencentH5CoreResultResponsetDto);


        return getTencentH5CoreResultResponsetDto;
    }


}
