package com.springboot.live_comm.controller.tencentF5;

import com.springboot.live_comm.entity.security.User;
import com.springboot.live_comm.entity.user.UserDetails;
import com.springboot.live_comm.services.security.UserService;
import com.springboot.live_comm.services.user.UserDetailsService;
import com.springboot.live_comm.tencentcloud.TencentCloudH5FaceCoreUtil;
import com.springboot.live_comm.tencentcloud.dto.TencentCloudPressButtonRequestDto;
import com.springboot.live_comm.tencentcloud.dto.TencentCloudPressButtonResponseDto;
import com.springboot.live_comm.tencentcloud.exception.ServiceException;
import com.springboot.live_comm.tencentcloud.utils.TencentCloudProperties;
import com.springboot.live_comm.utils.IdGeneratedUtil;
import freemarker.template.utility.StringUtil;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/tencentCloud")
public class TencentCloudController {
    public static Logger logger = LoggerFactory.getLogger(TencentCloudController.class);
    @Autowired
    TencentCloudProperties tencentCloudProperties;
    @Value("${hostaddress}")
    private String hostaddress;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/startF5", method = RequestMethod.POST)
    public TencentCloudPressButtonResponseDto startF5(TencentCloudPressButtonRequestDto tencentCloudPressButtonRequestDto, HttpSession session) throws ServiceException {
        TencentCloudPressButtonResponseDto tencentCloudPressButtonResponseDto;
        User loginUser = (User) session.getAttribute("loginUser");
        logger.info("loginUser is: {}", loginUser);
        User user = userService.getUserByUserName(loginUser.getUsername());
        logger.info("now loginUser is: {}", user);
        String detailsId = user.getDetailsId();
        if (!StringUtils.isBlank(detailsId)) {
            UserDetails userDetails = userDetailsService.getById(detailsId);
            logger.info("");
            if (userDetails.getCertification()) {
                tencentCloudPressButtonResponseDto = new TencentCloudPressButtonResponseDto();
                tencentCloudPressButtonResponseDto.setCode("101");
                tencentCloudPressButtonResponseDto.setMessage("已经通过了人脸核身了，无需再次进行人脸核身");
                return tencentCloudPressButtonResponseDto;
            }
        }

        String orderNo = IdGeneratedUtil.generateId();
        UserDetails userDetails = new UserDetails();
        userDetails.setId(orderNo);
        userDetails.setName(tencentCloudPressButtonRequestDto.getName());
//        暂时不将身份证号添加到数据库
//        userDetails.setIdNo(tencentCloudPressButtonRequestDto.getIdNo());
        userDetailsService.addUserDetails(userDetails);

        user.setDetailsId(userDetails.getId());
        userService.update(user);
        session.setAttribute("loginUser", user);


        String userId = user.getId().toString();
        tencentCloudPressButtonRequestDto.setUserId(userId);
        tencentCloudPressButtonRequestDto.setOrderNo(orderNo);
        TencentCloudH5FaceCoreUtil tencentCloudH5FaceCoreUtil = new TencentCloudH5FaceCoreUtil();

        String callbackUrl = tencentCloudProperties.getUrl();
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
                                     @RequestParam(value = "h5faceId", required = false) String h5faceId,
                                     ModelMap model, HttpSession session) {
        logger.info("start acceptF5Result and the applyId is: {}, code is: {}", orderNo, code);
        if ("0".equals(code)) {
//            认证成功
            UserDetails userDetails = userDetailsService.getById(orderNo);
            userDetails.setCertification(true);
            userDetailsService.update(userDetails);
        }


        String redirectUrl = "redirect:" + hostaddress + "/tencentCloudF5FaceCore?code=" + code;

        return redirectUrl;
    }
}
