package com.springboot.live_comm.tencentcloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.springboot.live_comm.tencentcloud.dto.*;
import com.springboot.live_comm.tencentcloud.service.ITencentCloudH5FaceCoreService;
import com.springboot.live_comm.tencentcloud.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TencentCloudH5FaceCoreServiceImpl implements ITencentCloudH5FaceCoreService {

    public static Logger logger = LoggerFactory.getLogger(TencentCloudH5FaceCoreServiceImpl.class);


    @Override
    public TencentCloudSendIdentityInformationResponseDto sendIdentityInformation(TencentCloudSendIdentityInformationRequestDto sendIdentityInformationRequestDto) {
        try {
            logger.info("now start sendIdentityInformation and the message is: {}", JSONObject.toJSONString(sendIdentityInformationRequestDto));
            TencentCloudSendIdentityInformationResponseDto sendIdentityInformationResponseDto;

            HttpUtil httpUtil = new HttpUtil();
            //获取参数，需要对值加判断
            String webankAppId = sendIdentityInformationRequestDto.getWebankAppId();
            String orderNo = sendIdentityInformationRequestDto.getOrderNo();
            String name = sendIdentityInformationRequestDto.getName();
            String idNo = sendIdentityInformationRequestDto.getIdNo();
            String userId = sendIdentityInformationRequestDto.getUserId();

            String version = sendIdentityInformationRequestDto.getVersion();
            String sign = sendIdentityInformationRequestDto.getSign();

            Map signTicketMap = new HashMap();
            signTicketMap.put("webankAppId", webankAppId);
            signTicketMap.put("orderNo", orderNo);
            signTicketMap.put("name", name);
            signTicketMap.put("idNo", idNo);
            signTicketMap.put("userId", userId);
            signTicketMap.put("version", version);
            signTicketMap.put("sign", sign);
            logger.info("map is " + JSON.toJSONString(signTicketMap));
            String setPersonResult = httpUtil.doPost(sendIdentityInformationRequestDto.getGetH5FaceIdUrl(), signTicketMap);
            logger.info("setPersonResult is : " + setPersonResult);

            sendIdentityInformationResponseDto = JSON.toJavaObject(JSON.parseObject(setPersonResult), TencentCloudSendIdentityInformationResponseDto.class);
            sendIdentityInformationResponseDto.reLoad();

            logger.info("sendIdentityInformation success, now end sendIdentityInformation");
            return sendIdentityInformationResponseDto;
        } catch (Exception e) {
            logger.error("Exception during sendIdentityInformation, now end sendIdentityInformation", e);
            TencentCloudSendIdentityInformationResponseDto tencentCloudSendIdentityInformationResponseDto = new TencentCloudSendIdentityInformationResponseDto();
            tencentCloudSendIdentityInformationResponseDto.setCode("-1");
            return tencentCloudSendIdentityInformationResponseDto;
        }
    }

    @Override
    public String startH5FaceCore(TencentCloudStartH5FaceCoreRequestDto startH5FaceCoreRequestDto) {
        try {
            logger.info("now start startH5FaceCore and the message is: {}", JSONObject.toJSONString(startH5FaceCoreRequestDto));
            //获取参数，需要对值加判断

            String optimalDomain = "miniprogram-kyc.tencentcloudapi.com";

            String webankAppId = startH5FaceCoreRequestDto.getWebankAppId();
            String version = startH5FaceCoreRequestDto.getVersion();
            String nonce = startH5FaceCoreRequestDto.getNonce();
            String orderNo = startH5FaceCoreRequestDto.getOrderNo();
            String h5faceId = startH5FaceCoreRequestDto.getH5faceId();
            String url = startH5FaceCoreRequestDto.getUrl();
            String resultType = startH5FaceCoreRequestDto.getResultType();
            String userId = startH5FaceCoreRequestDto.getUserId();
            String sign = startH5FaceCoreRequestDto.getSign();
            String from = startH5FaceCoreRequestDto.getFrom();
            String redirectType = startH5FaceCoreRequestDto.getRedirectType();

            String startH5FaceCoreUrl = "https://" + optimalDomain + "/api/web/login?webankAppId=" + webankAppId +
                    "&version=" + version +
                    "&nonce=" + nonce +
                    "&orderNo=" + orderNo +
                    "&h5faceId=" + h5faceId +
                    "&url=" + url +
                    "&resultType=" + resultType +
                    "&from=" + from +
                    "&userId=" + userId +
                    "&sign=" + sign + "&redirectType=" + redirectType;

            return startH5FaceCoreUrl;
        } catch (Exception e) {
            logger.error("Exception during getAccessToken, now end sendIdentityInformation", e);
            return "error";
        }
    }

    @Override
    public TencentCloudGetAccessTokenResponseDto getAccessToken(TencentCloudGetAccessTokenRequestDto getAccessTokenRequestDto) {

        logger.info("now start getAccessToken and the message is: {}", JSONObject.toJSONString(getAccessTokenRequestDto));
        TencentCloudGetAccessTokenResponseDto getAccessTokenResponseDto;
        HttpUtil httpUtil = new HttpUtil();
        //获取参数，需要对值加判断
        String app_id = getAccessTokenRequestDto.getApp_id();
        String secret = getAccessTokenRequestDto.getSecret();
        String grant_type = getAccessTokenRequestDto.getGrant_type();
        String version = getAccessTokenRequestDto.getVersion();
        String access_tokenUrl = getAccessTokenRequestDto.getAccess_tokenUrl();
        String tokenResult = httpUtil.getHTML(access_tokenUrl + "app_id=" + app_id + "&secret=" + secret + "&grant_type=" + grant_type + "&version=" + version);
        logger.info("gettokenResult is: " + tokenResult);
        getAccessTokenResponseDto = JSON.toJavaObject(JSON.parseObject(tokenResult), TencentCloudGetAccessTokenResponseDto.class);
        logger.info("getAccessToken success, now end getAccessToken");
        return getAccessTokenResponseDto;
    }

    @Override
    public TencentCloudGetSignTicketResponseDto getSignTicket(TencentCloudGetSignTicketRequestDto getSignTicketRequestDto) {
        try {
            logger.info("now start getSignTicket and the message is: {}", JSONObject.toJSONString(getSignTicketRequestDto));
            TencentCloudGetSignTicketResponseDto getSignTicketResponseDto;
            HttpUtil httpUtil = new HttpUtil();
            //获取参数，需要对值加判断
            String app_id = getSignTicketRequestDto.getApp_id();
            String access_token = getSignTicketRequestDto.getAccess_token();
            String type = getSignTicketRequestDto.getType();
            String version = getSignTicketRequestDto.getVersion();
            String api_ticketUrl = getSignTicketRequestDto.getApi_ticketUrl();

            String getSignTicketResult = httpUtil.getHTML(api_ticketUrl + "app_id=" + app_id + "&access_token=" + access_token + "&type=" + type + "&version=" + version);

            logger.info("getSignTicketResult is:" + getSignTicketResult);
            getSignTicketResponseDto = JSON.toJavaObject(JSON.parseObject(getSignTicketResult), TencentCloudGetSignTicketResponseDto.class);


            getSignTicketResponseDto.reload();

            logger.info("getSignTicket success, now end getSignTicket");
            return getSignTicketResponseDto;
        } catch (Exception e) {
            logger.error("Exception during getSignTicket, now end sendIdentityInformation", e);
            TencentCloudGetSignTicketResponseDto tencentCloudGetSignTicketResponseDto = new TencentCloudGetSignTicketResponseDto();
            tencentCloudGetSignTicketResponseDto.setCode("-1");
            return tencentCloudGetSignTicketResponseDto;
        }
    }

    @Override
    public TencentCloudGetNonceTicketResponseDto getNonceTicket(TencentCloudGetNonceTicketRequestDto getNonceTicketRequestDto) {
        try {
            logger.info("now start getNonceTicket and the message is: {}", JSONObject.toJSONString(getNonceTicketRequestDto));

            TencentCloudGetNonceTicketResponseDto getNonceTicketResponseDto;
            HttpUtil httpUtil = new HttpUtil();
            //获取参数，需要对值加判断
            String app_id = getNonceTicketRequestDto.getApp_id();
            String access_token = getNonceTicketRequestDto.getAccess_token();
            String type = getNonceTicketRequestDto.getType();
            String version = getNonceTicketRequestDto.getVersion();
            String user_id = getNonceTicketRequestDto.getUser_id();
            String api_ticketUrl = getNonceTicketRequestDto.getApi_ticketUrl();

            String getNonceTicketResult = httpUtil.getHTML(api_ticketUrl + "app_id=" + app_id + "&access_token=" + access_token + "&type=NONCE&version=" + version + "&user_id=" + user_id);
            logger.info("getNonceTicketResult is:" + getNonceTicketResult);
            getNonceTicketResponseDto = JSON.toJavaObject(JSON.parseObject(getNonceTicketResult), TencentCloudGetNonceTicketResponseDto.class);

            getNonceTicketResponseDto.reload();
            logger.info("getNonceTicket success, now end getNonceTicket");
            return getNonceTicketResponseDto;
        } catch (Exception e) {
            logger.error("Exception during getAccessToken, now end sendIdentityInformation", e);
            TencentCloudGetNonceTicketResponseDto tencentCloudGetNonceTicketResponseDto = new TencentCloudGetNonceTicketResponseDto();
            tencentCloudGetNonceTicketResponseDto.setCode("-1");
            return tencentCloudGetNonceTicketResponseDto;
        }
    }

    @Override
    public GetTencentH5CoreResultResponsetDto getH5FaceCoreResult(GetTencentH5CoreResultRequestDto getTencentH5CoreResultRequestDto) {
        GetTencentH5CoreResultResponsetDto getTencentH5CoreResultResponsetDto = new GetTencentH5CoreResultResponsetDto();
        try {
            logger.info("now start getH5FaceCoreResult and the message is: {}", JSONObject.toJSONString(getTencentH5CoreResultRequestDto));
            HttpUtil httpUtil = new HttpUtil();
            String app_id = getTencentH5CoreResultRequestDto.getApp_id();
            String nonce = getTencentH5CoreResultRequestDto.getNonce();
            String order_no = getTencentH5CoreResultRequestDto.getOrder_no();
            String version = getTencentH5CoreResultRequestDto.getVersion();
            String sign = getTencentH5CoreResultRequestDto.getSign();
            String get_file = getTencentH5CoreResultRequestDto.getGet_file();
            String getTencentH5CoreResult = httpUtil.getHTML(getTencentH5CoreResultRequestDto.getGetH5CoreResultUrl() + "app_id=" + app_id + "&nonce=" + nonce + "&order_no=" + order_no + "&version=" + version + "&sign=" + sign + "&get_file=" + get_file);
            getTencentH5CoreResultResponsetDto = JSON.toJavaObject(JSON.parseObject(getTencentH5CoreResult), GetTencentH5CoreResultResponsetDto.class);
            getTencentH5CoreResultResponsetDto.reload();
            logger.info("getTencentH5CoreResultResponsetDto is: " + getTencentH5CoreResultResponsetDto);
            logger.info("getH5FaceCoreResult success, now end getNonceTicket");
            return getTencentH5CoreResultResponsetDto;
        } catch (Exception e) {
            logger.error("Exception during getH5FaceCoreResult, now end getH5FaceCoreResult", e);
            e.printStackTrace();
            getTencentH5CoreResultResponsetDto.setCode("-1");
            return getTencentH5CoreResultResponsetDto;
        }
    }

}
