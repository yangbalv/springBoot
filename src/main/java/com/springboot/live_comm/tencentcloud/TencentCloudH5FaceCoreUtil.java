package com.springboot.live_comm.tencentcloud;


import com.alibaba.fastjson.JSONObject;
import com.springboot.live_comm.tencentcloud.dto.*;
import com.springboot.live_comm.tencentcloud.exception.ServiceException;
import com.springboot.live_comm.tencentcloud.service.ITencentCloudH5FaceCoreService;
import com.springboot.live_comm.tencentcloud.service.impl.TencentCloudH5FaceCoreServiceImpl;
import com.springboot.live_comm.tencentcloud.utils.SHA1Util;
import com.springboot.live_comm.tencentcloud.utils.TencentCloudProperties;
import com.springboot.live_comm.utils.IdGeneratedUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class TencentCloudH5FaceCoreUtil {
    Logger logger = LoggerFactory.getLogger(TencentCloudH5FaceCoreUtil.class);

    public TencentCloudPressButtonResponseDto pressButton(TencentCloudPressButtonRequestDto pressButtonDto, TencentCloudProperties tencentCloudProperties, String callbackUrl) throws ServiceException {
        logger.info("now start pressButton and the message is: {}", JSONObject.toJSONString(pressButtonDto));

        TencentCloudPressButtonResponseDto pressButtonResponseDto = new TencentCloudPressButtonResponseDto();

//           腾讯云配置文件
        String webankAppId = tencentCloudProperties.getWebankAppId();
        String secret = tencentCloudProperties.getSecret();
        final String grant_type = tencentCloudProperties.getGrant_type();
        String version = tencentCloudProperties.getVersion();
        final String SIGN_TYPE = tencentCloudProperties.getSIGN_TYPE();
        final String NONCE_TYPE = tencentCloudProperties.getNONCE_TYPE();



        String resultType = tencentCloudProperties.getResultType();
        String from = tencentCloudProperties.getFrom();
        String redirectType = tencentCloudProperties.getRedirectType();

        String getH5FaceIdUrl = tencentCloudProperties.getGetH5FaceIdUrl();
        String access_tokenUrl = tencentCloudProperties.getAccess_tokenUrl();
        String api_ticketUrl = tencentCloudProperties.getApi_ticketUrl();


        //获取参数，需要对值加判断

        String name = pressButtonDto.getName();
        String idNo = pressButtonDto.getIdNo();

//            我方生成的订单号以及用户的名称, 采用apply 的id
        String orderNo = pressButtonDto.getOrderNo();               //订单号，字母/数字组成的字符串，本次人脸核身合作伙伴上送的订单号，唯一标识	合作方自行分配，不要带有特殊字符

        // 生成用户userid的方法 , 采用apply 的id的反转
        String userId = pressButtonDto.getUserId();//	用户 ID，用户的唯一标识（不要带有特殊字符）	合作方自行分配

//            随机数  生成用户 nonce 的方法
        String nonce = IdGeneratedUtil.generateId();  //32位随机串（字母+数字组成的随机数）	合作方自行生成（与接口中定义的随机数保持一致，不要带有特殊字符）
        //  创建工具类实体
        ITencentCloudH5FaceCoreService tencentH5FaceCoreService = new TencentCloudH5FaceCoreServiceImpl();
//      首先获取token
//          构造方法构造获取token的请求
        TencentCloudGetAccessTokenRequestDto tencentCloudGetAccessTokenRequestDto = new TencentCloudGetAccessTokenRequestDto(webankAppId, secret, grant_type, version);
        tencentCloudGetAccessTokenRequestDto.setAccess_tokenUrl(access_tokenUrl);
//          获得获取token的结果
        TencentCloudGetAccessTokenResponseDto getAccessTokenResponseDto = tencentH5FaceCoreService.getAccessToken(tencentCloudGetAccessTokenRequestDto);
        if (!"0".equals(getAccessTokenResponseDto.getCode())) {
            logger.info("getAccessTokenResponseDto failed case: {}, ", getAccessTokenResponseDto.getMsg());
            throw new ServiceException(getAccessTokenResponseDto.getMsg(), "-1");
        }
        String access_token = getAccessTokenResponseDto.getAccess_token();
//      然后获取sign型的ticket
//          构造方法构造获取SIGNTICKET的请求
        TencentCloudGetSignTicketRequestDto tencentCloudGetSignTicketRequestDto = new TencentCloudGetSignTicketRequestDto(webankAppId, access_token, SIGN_TYPE, version);
        tencentCloudGetSignTicketRequestDto.setApi_ticketUrl(api_ticketUrl);
//          获得获取SIGNTICKET的结果
        TencentCloudGetSignTicketResponseDto getSignTicketResponseDto = tencentH5FaceCoreService.getSignTicket(tencentCloudGetSignTicketRequestDto);
        if (!"0".equals(getSignTicketResponseDto.getCode())) {
            logger.info("getSignTicketResponseDto failed case: {}, ", getSignTicketResponseDto.getMsg());
            throw new ServiceException(getSignTicketResponseDto.getMsg(), "-1");
        }
//            获取到的signticket
        String signTicket = getSignTicketResponseDto.getTicket();

        TencentCloudMakeSignTicketSignDto tencentCloudMakeSignTicketSignDto = new TencentCloudMakeSignTicketSignDto(webankAppId, orderNo, name, idNo, userId, version, signTicket);
//      通过SIGN型的TICKET制作sign
//          利用构造方法构建实体类\
        logger.info("tencentCloudMakeSignTicketSignDto is:" + tencentCloudMakeSignTicketSignDto.toString());
        String signTicketSign = SHA1Util.sign(tencentCloudMakeSignTicketSignDto.toList(), signTicket);

//      上传信息
//          构造方法构造上传信息的请求
        TencentCloudSendIdentityInformationRequestDto tencentCloudSendIdentityInformationRequestDto = new TencentCloudSendIdentityInformationRequestDto(webankAppId, orderNo, name, idNo, userId, version, signTicketSign);
        tencentCloudSendIdentityInformationRequestDto.setGetH5FaceIdUrl(getH5FaceIdUrl);
//          获取结果
        TencentCloudSendIdentityInformationResponseDto sendIdentityInformationResponseDto = tencentH5FaceCoreService.sendIdentityInformation(tencentCloudSendIdentityInformationRequestDto);
        if (!"0".equals(sendIdentityInformationResponseDto.getCode())) {
            logger.info("sendIdentityInformationResponseDto failed case: {}, ", sendIdentityInformationResponseDto.getMsg());
            throw new ServiceException(sendIdentityInformationResponseDto.getMsg(), "-1");
        }
        logger.info("sendIdentityInformationResponseDto is:" + sendIdentityInformationResponseDto.toString());
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
        if (!"0".equals(getNonceTicketResponseDto.getCode())) {
            logger.info("getNonceTicketResponseDto failed case: {}, ", getNonceTicketResponseDto.getMsg());
            throw new ServiceException(getNonceTicketResponseDto.getMsg(), "-1");
        }
        String nonceTicket = getNonceTicketResponseDto.getTicket();
//      然后获取nonce——ticket的sign
        TencentCloudMakeNonceSignTicketSignDto tencentCloudMakeNonceSignTicketSignDto = new TencentCloudMakeNonceSignTicketSignDto(webankAppId, orderNo, userId, version, h5faceId, nonceTicket, nonce);

        List nonceTicketList = tencentCloudMakeNonceSignTicketSignDto.toList();
        String nonceSign = SHA1Util.sign(nonceTicketList, getNonceTicketResponseDto.getTicket());

        TencentCloudStartH5FaceCoreRequestDto tencentCloudStartH5FaceCoreRequestDto = new TencentCloudStartH5FaceCoreRequestDto(webankAppId, version, nonce, orderNo, h5faceId, callbackUrl, resultType, userId, nonceSign, from, redirectType);

        String result = tencentH5FaceCoreService.startH5FaceCore(tencentCloudStartH5FaceCoreRequestDto);
        pressButtonResponseDto.setCode(sendIdentityInformationResponseDto.getCode());
        pressButtonResponseDto.setMessage("success");
        pressButtonResponseDto.setUrl(result);

        logger.info("now end pressButton, and the pressButtonResponseDto is: {}", pressButtonResponseDto);
        System.out.println("now end pressButton, and the pressButtonResponseDto is: " + pressButtonResponseDto);
        return pressButtonResponseDto;

    }

    public TencentCloudPressButtonResponseDto pressButton(GetTencentFaceCoreUrlBaseReqDto pressButtonDto, TencentCloudProperties tencentCloudProperties, String callbackUrl) throws ServiceException, UnsupportedEncodingException {
        logger.info("now start pressButton and the message is: {}", JSONObject.toJSONString(pressButtonDto));
        TencentCloudPressButtonResponseDto pressButtonResponseDto = new TencentCloudPressButtonResponseDto();

//           腾讯云配置文件
        String webankAppId = tencentCloudProperties.getWebankAppId();
        String secret = tencentCloudProperties.getSecret();
        final String grant_type = tencentCloudProperties.getGrant_type();
        String version = tencentCloudProperties.getVersion();
        final String SIGN_TYPE = tencentCloudProperties.getSIGN_TYPE();
        final String NONCE_TYPE = tencentCloudProperties.getNONCE_TYPE();

        String url;
        try {
            url = java.net.URLEncoder.encode(callbackUrl, "UTF-8");//url做encode处理 encode 是加密，deCode是解密
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException during decode the url", e);
            throw e;
        }

        String resultType = tencentCloudProperties.getResultType();
        String from = tencentCloudProperties.getFrom();
        String redirectType = tencentCloudProperties.getRedirectType();

        String getH5FaceIdUrl = tencentCloudProperties.getGetH5FaceIdUrl();
        String access_tokenUrl = tencentCloudProperties.getAccess_tokenUrl();
        String api_ticketUrl = tencentCloudProperties.getApi_ticketUrl();


        //获取参数，需要对值加判断

        String name = pressButtonDto.getName();
        String idNo = pressButtonDto.getIdNo();

//            我方生成的订单号以及用户的名称, 采用apply 的id
        String orderNo = pressButtonDto.getOrderNo();               //订单号，字母/数字组成的字符串，本次人脸核身合作伙伴上送的订单号，唯一标识	合作方自行分配，不要带有特殊字符

        // 生成用户userid的方法 , 采用apply 的id的反转
        String userId = pressButtonDto.getUserId();//	用户 ID，用户的唯一标识（不要带有特殊字符）	合作方自行分配

//            随机数  生成用户 nonce 的方法
        String nonce = IdGeneratedUtil.generateId();  //32位随机串（字母+数字组成的随机数）	合作方自行生成（与接口中定义的随机数保持一致，不要带有特殊字符）
        //  创建工具类实体
        ITencentCloudH5FaceCoreService tencentH5FaceCoreService = new TencentCloudH5FaceCoreServiceImpl();
//      首先获取token
//          构造方法构造获取token的请求
        TencentCloudGetAccessTokenRequestDto tencentCloudGetAccessTokenRequestDto = new TencentCloudGetAccessTokenRequestDto(webankAppId, secret, grant_type, version);
        tencentCloudGetAccessTokenRequestDto.setAccess_tokenUrl(access_tokenUrl);
//          获得获取token的结果
        TencentCloudGetAccessTokenResponseDto getAccessTokenResponseDto = tencentH5FaceCoreService.getAccessToken(tencentCloudGetAccessTokenRequestDto);
        if (!"0".equals(getAccessTokenResponseDto.getCode())) {
            logger.info("getAccessTokenResponseDto failed case: {}, ", getAccessTokenResponseDto.getMsg());
            throw new ServiceException(getAccessTokenResponseDto.getMsg(), "-1");
        }
        String access_token = getAccessTokenResponseDto.getAccess_token();
//      然后获取sign型的ticket
//          构造方法构造获取SIGNTICKET的请求
        TencentCloudGetSignTicketRequestDto tencentCloudGetSignTicketRequestDto = new TencentCloudGetSignTicketRequestDto(webankAppId, access_token, SIGN_TYPE, version);
        tencentCloudGetSignTicketRequestDto.setApi_ticketUrl(api_ticketUrl);
//          获得获取SIGNTICKET的结果
        TencentCloudGetSignTicketResponseDto getSignTicketResponseDto = tencentH5FaceCoreService.getSignTicket(tencentCloudGetSignTicketRequestDto);
        if (!"0".equals(getSignTicketResponseDto.getCode())) {
            logger.info("getSignTicketResponseDto failed case: {}, ", getSignTicketResponseDto.getMsg());
            throw new ServiceException(getSignTicketResponseDto.getMsg(), "-1");
        }
//            获取到的signticket
        String signTicket = getSignTicketResponseDto.getTicket();

        TencentCloudMakeSignTicketSignDto tencentCloudMakeSignTicketSignDto = new TencentCloudMakeSignTicketSignDto(webankAppId, orderNo, name, idNo, userId, version, signTicket);
//      通过SIGN型的TICKET制作sign
//          利用构造方法构建实体类\
        logger.info("tencentCloudMakeSignTicketSignDto is:" + tencentCloudMakeSignTicketSignDto.toString());
        String signTicketSign = SHA1Util.sign(tencentCloudMakeSignTicketSignDto.toList(), signTicket);

//      上传信息
//          构造方法构造上传信息的请求
        TencentCloudSendIdentityInformationRequestDto tencentCloudSendIdentityInformationRequestDto = new TencentCloudSendIdentityInformationRequestDto(webankAppId, orderNo, name, idNo, userId, version, signTicketSign);
        tencentCloudSendIdentityInformationRequestDto.setGetH5FaceIdUrl(getH5FaceIdUrl);
//          获取结果
        TencentCloudSendIdentityInformationResponseDto sendIdentityInformationResponseDto = tencentH5FaceCoreService.sendIdentityInformation(tencentCloudSendIdentityInformationRequestDto);
        if (!"0".equals(sendIdentityInformationResponseDto.getCode())) {
            logger.info("sendIdentityInformationResponseDto failed case: {}, ", sendIdentityInformationResponseDto.getMsg());
            throw new ServiceException(sendIdentityInformationResponseDto.getMsg(), "-1");
        }
        logger.info("sendIdentityInformationResponseDto is:" + sendIdentityInformationResponseDto.toString());
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
        if (!"0".equals(getNonceTicketResponseDto.getCode())) {
            logger.info("getNonceTicketResponseDto failed case: {}, ", getNonceTicketResponseDto.getMsg());
            throw new ServiceException(getNonceTicketResponseDto.getMsg(), "-1");
        }
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

    }

    //    只需要上传orderNo就行了
//获取人脸核身的信息
    public GetTencentH5CoreResultResponsetDto getTencentH5CoreResult(GetTencentH5CoreResultRequestDto getTencentH5CoreResultRequestDto, TencentCloudProperties tencentCloudProperties) throws ServiceException {

//           腾讯云配置文件
        String webankAppId = tencentCloudProperties.getWebankAppId();
        String secret = tencentCloudProperties.getSecret();
        final String grant_type = tencentCloudProperties.getGrant_type();
        String version = tencentCloudProperties.getVersion();
        final String SIGN_TYPE = tencentCloudProperties.getSIGN_TYPE();

        String access_tokenUrl = tencentCloudProperties.getAccess_tokenUrl();
        String api_ticketUrl = tencentCloudProperties.getApi_ticketUrl();
        String getH5CoreResultUrl = tencentCloudProperties.getGetH5CoreResultUrl();
        String get_file = tencentCloudProperties.getGet_file();


//            我方生成的订单号以及用户的名称
        String orderNo = getTencentH5CoreResultRequestDto.getOrder_no();               //订单号，字母/数字组成的字符串，本次人脸核身合作伙伴上送的订单号，唯一标识	合作方自行分配，不要带有特殊字符


        //            随机数
        String nonce = IdGeneratedUtil.generateId();//32位随机串（字母+数字组成的随机数）	合作方自行生成（与接口中定义的随机数保持一致，不要带有特殊字符）

        //  创建工具类实体
        ITencentCloudH5FaceCoreService tencentH5FaceCoreService = new TencentCloudH5FaceCoreServiceImpl();
//      首先获取token
//          构造方法构造获取token的请求
        TencentCloudGetAccessTokenRequestDto tencentCloudGetAccessTokenRequestDto = new TencentCloudGetAccessTokenRequestDto(webankAppId, secret, grant_type, version);
        tencentCloudGetAccessTokenRequestDto.setAccess_tokenUrl(access_tokenUrl);
//          获得获取token的结果
        TencentCloudGetAccessTokenResponseDto getAccessTokenResponseDto = tencentH5FaceCoreService.getAccessToken(tencentCloudGetAccessTokenRequestDto);
        if (!"0".equals(getAccessTokenResponseDto.getCode())) {
            logger.info("getAccessTokenResponseDto failed case: {}, ", getAccessTokenResponseDto.getMsg());
            throw new ServiceException(getAccessTokenResponseDto.getMsg(), "-1");
        }
//        System.out.println(getAccessTokenResponseDto.toString());
        String access_token = getAccessTokenResponseDto.getAccess_token();

//          制作ticket
        TencentCloudGetSignTicketRequestDto tencentCloudGetSignTicketRequestDto = new TencentCloudGetSignTicketRequestDto(webankAppId, access_token, SIGN_TYPE, version);
        tencentCloudGetSignTicketRequestDto.setApi_ticketUrl(api_ticketUrl);
        TencentCloudGetSignTicketResponseDto tencentCloudGetSignTicketResponseDto = tencentH5FaceCoreService.getSignTicket(tencentCloudGetSignTicketRequestDto);
        if (!"0".equals(tencentCloudGetSignTicketResponseDto.getCode())) {
            logger.info("tencentCloudGetSignTicketResponseDto failed case: {}, ", tencentCloudGetSignTicketResponseDto.getMsg());
            throw new ServiceException(tencentCloudGetSignTicketResponseDto.getMsg(), "-1");
        }
//        System.out.println("tencentCloudGetSignTicketResponseDto is: " + tencentCloudGetSignTicketResponseDto);
        String makeSignTicket = tencentCloudGetSignTicketResponseDto.getTicket();
        List<String> makeSignList = new ArrayList<>();
        makeSignList.add(webankAppId);
        makeSignList.add(version);
        makeSignList.add(nonce);
        makeSignList.add(orderNo);
        String getH5FaceCoreResultSign = SHA1Util.sign(makeSignList, makeSignTicket);

        getTencentH5CoreResultRequestDto.setOrder_no(orderNo);
        getTencentH5CoreResultRequestDto.setApp_id(webankAppId);
        getTencentH5CoreResultRequestDto.setVersion(version);
        getTencentH5CoreResultRequestDto.setGet_file(get_file);
        getTencentH5CoreResultRequestDto.setNonce(nonce);
        getTencentH5CoreResultRequestDto.setSign(getH5FaceCoreResultSign);
        getTencentH5CoreResultRequestDto.setGetH5CoreResultUrl(getH5CoreResultUrl);


        GetTencentH5CoreResultResponsetDto getTencentH5CoreResultResponsetDto;
        getTencentH5CoreResultResponsetDto = tencentH5FaceCoreService.getH5FaceCoreResult(getTencentH5CoreResultRequestDto);
        if (!"0".equals(getTencentH5CoreResultResponsetDto.getCode())) {
            logger.info("getTencentH5CoreResultResponsetDto failed case: {}, ", getTencentH5CoreResultResponsetDto.getMsg());
            throw new ServiceException(getTencentH5CoreResultResponsetDto.getMsg(), "-1");
        }

        return getTencentH5CoreResultResponsetDto;
    }

}
