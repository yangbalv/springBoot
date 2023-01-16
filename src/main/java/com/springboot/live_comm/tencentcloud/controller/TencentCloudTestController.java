package com.springboot.live_comm.tencentcloud.controller;

import com.alibaba.fastjson.JSONObject;

import com.springboot.live_comm.tencentcloud.TencentCloudH5FaceCoreUtil;
import com.springboot.live_comm.tencentcloud.dto.*;
import com.springboot.live_comm.tencentcloud.exception.ServiceException;
import com.springboot.live_comm.tencentcloud.utils.TencentCloudProperties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping(value = "/testProperties")
public class TencentCloudTestController {
    public static Logger logger = LoggerFactory.getLogger(TencentCloudTestController.class);
    @Autowired
    TencentCloudProperties tencentCloudProperties;
    @Value("${hostaddress}")
    private String hostaddress;

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

    /**
     * 腾讯云人脸识别的回调接口
     *
     * @param code
     * @param orderNo
     * @param h5faceId
     * @return
     */
    @RequestMapping(value = "/acceptF5Result", method = RequestMethod.GET)
    public String testAcceptF5Result(@RequestParam(value = "code") String code,
                                     @RequestParam(value = "orderNo") String orderNo,
                                     @RequestParam(value = "userId") String userId,
                                     @RequestParam(value = "h5faceId", required = false) String h5faceId,
                                     ModelMap model, HttpSession session) throws ServiceException, UnsupportedEncodingException {
        logger.info("start acceptF5Result and the applyId is: {}, code is: {}", orderNo, code);

//        logger.info("上传人脸核身视频之前的 apply : " + finalApply);
//      获取人脸核身的结果，上传人脸核身的视频
        TencentCloudH5FaceCoreUtil tencentCloudH5FaceCoreUtil = new TencentCloudH5FaceCoreUtil();
        GetTencentH5CoreResultRequestDto getTencentH5CoreResultRequestDto = new GetTencentH5CoreResultRequestDto();
//添加订单号
        getTencentH5CoreResultRequestDto.setOrder_no(orderNo);

        GetTencentH5CoreResultResponsetDto getTencentH5CoreResultResponsetDto = null;
        try {
            getTencentH5CoreResultResponsetDto = tencentCloudH5FaceCoreUtil.getTencentH5CoreResult(getTencentH5CoreResultRequestDto, tencentCloudProperties);
        } catch (ServiceException e) {
            logger.error("ServiceException during getTencentH5CoreResult", e);
            throw e;
        }
//        void就是base64的视频内容;
        String video = getTencentH5CoreResultResponsetDto.getVideo();
//        使用redirect进行页面跳转
        String redirectUrl = "redirect:" + hostaddress + "/assets/creditcard/apply/index.html#/apply/ordinary/step-unionpay-trial?";

        return redirectUrl;
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
