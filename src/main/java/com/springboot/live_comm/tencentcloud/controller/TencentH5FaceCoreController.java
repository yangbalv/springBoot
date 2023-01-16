package com.springboot.live_comm.tencentcloud.controller;


import com.alibaba.fastjson.JSONObject;

import com.springboot.live_comm.tencentcloud.dto.*;
import com.springboot.live_comm.tencentcloud.service.ITencentCloudH5FaceCoreService;
import com.springboot.live_comm.tencentcloud.service.impl.TencentCloudH5FaceCoreServiceImpl;
import com.springboot.live_comm.tencentcloud.utils.SHA1Util;
import com.springboot.live_comm.tencentcloud.utils.TencentCloudProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(value = "/face")
public class TencentH5FaceCoreController {
    Logger logger = LoggerFactory.getLogger(TencentH5FaceCoreController.class);

    @Autowired
    TencentCloudProperties tencentCloudProperties;

    @ResponseBody
    @RequestMapping(value = "/pressButton")
    public TencentCloudPressButtonResponseDto pressButton(@RequestBody TencentCloudPressButtonRequestDto pressButtonDto) {
        try {
            logger.info("now start pressButton and the message is: {}", JSONObject.toJSONString(pressButtonDto));

            TencentCloudPressButtonResponseDto pressButtonResponseDto = new TencentCloudPressButtonResponseDto();

//           腾讯云配置文件
            String webankAppId = tencentCloudProperties.getWebankAppId();
            String secret = tencentCloudProperties.getSecret();
            final String grant_type = tencentCloudProperties.getGrant_type();
            String version = tencentCloudProperties.getVersion();
            final String SIGN_TYPE = tencentCloudProperties.getSIGN_TYPE();
            final String NONCE_TYPE = tencentCloudProperties.getNONCE_TYPE();
            String url = tencentCloudProperties.getUrl();
            String resultType = tencentCloudProperties.getResultType();
            String from = tencentCloudProperties.getFrom();
            String redirectType = tencentCloudProperties.getRedirectType();

            String getH5FaceIdUrl = tencentCloudProperties.getGetH5FaceIdUrl();
            String access_tokenUrl = tencentCloudProperties.getAccess_tokenUrl();
            String api_ticketUrl = tencentCloudProperties.getApi_ticketUrl();


            //获取参数，需要对值加判断

            String name = pressButtonDto.getName();
            String idNo = pressButtonDto.getIdNo();

//            我方生成的订单号以及用户的名称 todo 生成订单号
            String orderNo = "orderNo2022012050";
            //todo 生成用户userid的方法
            String userId = "user20220120";
//            随机数 todo 生成用户 nonce 的方法
            String nonce = "kHoSxvLZGxSoFsjxcdzEoUzj6PAmT7BT";

            //  创建工具类实体
            ITencentCloudH5FaceCoreService tencentH5FaceCoreService = new TencentCloudH5FaceCoreServiceImpl();
//      首先获取token
//          构造方法构造获取token的请求
            TencentCloudGetAccessTokenRequestDto tencentCloudGetAccessTokenRequestDto = new TencentCloudGetAccessTokenRequestDto(webankAppId, secret, grant_type, version);
            tencentCloudGetAccessTokenRequestDto.setAccess_tokenUrl(access_tokenUrl);
//          获得获取token的结果
            TencentCloudGetAccessTokenResponseDto getAccessTokenResponseDto = tencentH5FaceCoreService.getAccessToken(tencentCloudGetAccessTokenRequestDto);
            String access_token = getAccessTokenResponseDto.getAccess_token();
//      然后获取sign型的ticket
//          构造方法构造获取SIGNTICKET的请求
            TencentCloudGetSignTicketRequestDto tencentCloudGetSignTicketRequestDto = new TencentCloudGetSignTicketRequestDto(webankAppId, access_token, SIGN_TYPE, version);
            tencentCloudGetSignTicketRequestDto.setApi_ticketUrl(api_ticketUrl);
//          获得获取SIGNTICKET的结果
            TencentCloudGetSignTicketResponseDto getSignTicketResponseDto = tencentH5FaceCoreService.getSignTicket(tencentCloudGetSignTicketRequestDto);
//            获取到的signticket
            String signTicket = getSignTicketResponseDto.getTicket();

            TencentCloudMakeSignTicketSignDto tencentCloudMakeSignTicketSignDto = new TencentCloudMakeSignTicketSignDto(webankAppId, orderNo, name, idNo, userId, version, signTicket);
//      通过SIGN型的TICKET制作sign
//          利用构造方法构建实体类\

            String signTicketSign = SHA1Util.sign(tencentCloudMakeSignTicketSignDto.toList(), signTicket);

//      上传信息
//          构造方法构造上传信息的请求
            TencentCloudSendIdentityInformationRequestDto tencentCloudSendIdentityInformationRequestDto = new TencentCloudSendIdentityInformationRequestDto(webankAppId, orderNo, name, idNo, userId, version, signTicketSign);
            tencentCloudSendIdentityInformationRequestDto.setGetH5FaceIdUrl(getH5FaceIdUrl);
//          获取结果
            TencentCloudSendIdentityInformationResponseDto sendIdentityInformationResponseDto = tencentH5FaceCoreService.sendIdentityInformation(tencentCloudSendIdentityInformationRequestDto);

            System.out.println("sendIdentityInformationResponseDto is:" + sendIdentityInformationResponseDto);
//          异常结果处理
            if (!"0".equals(sendIdentityInformationResponseDto.getCode())) {

                pressButtonResponseDto.setCode(sendIdentityInformationResponseDto.getCode());
                pressButtonResponseDto.setMessage(sendIdentityInformationResponseDto.getMsg());
                return pressButtonResponseDto;
                //上传信息异常
            }
//          获取到此次人脸核身的唯一标识
            String h5faceId = sendIdentityInformationResponseDto.getH5faceId();


//      然后获取nonce型的ticket
            TencentCloudGetNonceTicketRequestDto tencentCloudGetNonceTicketRequestDto = new TencentCloudGetNonceTicketRequestDto(webankAppId, access_token, NONCE_TYPE, version, userId);
            tencentCloudGetNonceTicketRequestDto.setApi_ticketUrl(api_ticketUrl);
            TencentCloudGetNonceTicketResponseDto getNonceTicketResponseDto = tencentH5FaceCoreService.getNonceTicket(tencentCloudGetNonceTicketRequestDto);
            String nonceTicket = getNonceTicketResponseDto.getTicket();
//      然后获取nonce——ticket的sign
            TencentCloudMakeNonceSignTicketSignDto tencentCloudMakeNonceSignTicketSignDto = new TencentCloudMakeNonceSignTicketSignDto(webankAppId, orderNo, userId, version, h5faceId, nonceTicket, nonce);

            List nonceTicketList = tencentCloudMakeNonceSignTicketSignDto.toList();
            String nonceSign = SHA1Util.sign(nonceTicketList, getNonceTicketResponseDto.getTicket());

            TencentCloudStartH5FaceCoreRequestDto tencentCloudStartH5FaceCoreRequestDto = new TencentCloudStartH5FaceCoreRequestDto(webankAppId, version, nonce, orderNo, h5faceId, url, resultType, userId, nonceSign, from, redirectType);

            String result = tencentH5FaceCoreService.startH5FaceCore(tencentCloudStartH5FaceCoreRequestDto);
            pressButtonResponseDto.setCode(sendIdentityInformationResponseDto.getCode());
            pressButtonResponseDto.setMessage("success");
            pressButtonResponseDto.setUrl(result);

            logger.info("now end pressButton, and the pressButtonResponseDto is: {}", pressButtonResponseDto);
            System.out.println("now end pressButton, and the pressButtonResponseDto is: " + pressButtonResponseDto);
            return pressButtonResponseDto;
        } catch (Exception e) {
            System.out.println("Exception during pressButton now end sendIdentityInformation " + e);
            logger.info("now end pressButton");
            System.out.println("now end pressButton");
//            logger.error("Exception during sendIdentityInformation, now end sendIdentityInformation", e);
            TencentCloudPressButtonResponseDto pressButtonResponseDto = new TencentCloudPressButtonResponseDto();
            pressButtonResponseDto.setCode("-1");
            pressButtonResponseDto.setMessage("运行中出现异常");
            return pressButtonResponseDto;
        }
    }
//    public static void main(String[] args) {
//        String s = "/1/a1/11///11///4";
//        String[] ss = s.split("/");
//        System.out.println(Arrays.toString(ss));
//        System.out.println("*" + (ss[0]) + "*");
//        System.out.println("*" + (ss[0].length()) + "*");
//        System.out.println("*" + (ss[0] == null) + "*");
//        System.out.println("*" + StringUtils.isBlank(ss[0]) + "*");
//    }

}
