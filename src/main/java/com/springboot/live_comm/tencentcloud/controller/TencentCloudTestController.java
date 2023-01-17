package com.springboot.live_comm.tencentcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.live_comm.tencentcloud.TencentCloudH5FaceCoreUtil;
import com.springboot.live_comm.tencentcloud.dto.*;
import com.springboot.live_comm.tencentcloud.exception.ServiceException;
import com.springboot.live_comm.tencentcloud.utils.MakeVideoUtil;
import com.springboot.live_comm.tencentcloud.utils.TencentCloudProperties;
import com.springboot.live_comm.utils.IdGeneratedUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/testProperties")
public class TencentCloudTestController {
    public static Logger logger = LoggerFactory.getLogger(TencentCloudTestController.class);
    @Autowired
    TencentCloudProperties tencentCloudProperties;
    @Value("${hostaddress}")
    private String hostaddress;


    @ResponseBody
    @RequestMapping(value = "/startF5", method = RequestMethod.POST)
    public TencentCloudPressButtonResponseDto startF5(TencentCloudPressButtonRequestDto tencentCloudPressButtonRequestDto) throws ServiceException {
        String orderNo = IdGeneratedUtil.generateId();
        String userId = orderNo;
        tencentCloudPressButtonRequestDto.setUserId(userId);
        tencentCloudPressButtonRequestDto.setOrderNo(orderNo);
        TencentCloudH5FaceCoreUtil tencentCloudH5FaceCoreUtil = new TencentCloudH5FaceCoreUtil();
        TencentCloudPressButtonResponseDto tencentCloudPressButtonResponseDto;
        String callbackUrl = "http://www.jpfdx.online:8090/zty/testProperties/acceptF5Result";
        try {
            callbackUrl = java.net.URLEncoder.encode(callbackUrl, "UTF-8");//url做encode处理 encode 是加密，deCode是解密
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException during decode the url: {}", callbackUrl, e);
        }
        try {
            tencentCloudPressButtonResponseDto = tencentCloudH5FaceCoreUtil.pressButton(tencentCloudPressButtonRequestDto, tencentCloudProperties, callbackUrl);
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

    @ResponseBody
    @RequestMapping(value = "/testGetF5Result2", method = RequestMethod.POST)
    public GetTencentH5CoreResultResponsetDto testGetF5Result2(@RequestBody GetTencentH5CoreResultRequestDto getTencentH5CoreResultRequestDto) {
        TencentCloudH5FaceCoreUtil tencentCloudH5FaceCoreUtil = new TencentCloudH5FaceCoreUtil();
        getTencentH5CoreResultRequestDto.setOrder_no(getTencentH5CoreResultRequestDto.getOrder_no());
        GetTencentH5CoreResultResponsetDto getTencentH5CoreResultResponsetDto = null;
        try {
            getTencentH5CoreResultResponsetDto = tencentCloudH5FaceCoreUtil.getTencentH5CoreResult(getTencentH5CoreResultRequestDto, tencentCloudProperties);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        String video = getTencentH5CoreResultResponsetDto.getVideo();
        MakeVideoUtil.base64ToVideo(video, "D:\\Java\\a.mp4");
        return getTencentH5CoreResultResponsetDto;
    }

}
