package com.springboot.live_comm.controller.test;

import com.springboot.live_comm.dto.BaseStatusResponseDto;
import com.springboot.live_comm.services.polymorphic.actions.PersonAction;
import com.springboot.live_comm.services.polymorphic.models.abstractmodel.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    Student student;

    @RequestMapping("hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie[] cookie = request.getCookies();
        if (null != cookie) {

            for (Cookie cookie1 : cookie) {
                System.out.println(cookie1.getName());
                System.out.println(cookie1.getValue());
            }
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            System.out.println(headerName + " : " + request.getHeader(headerName));
        }
        out.print("<DATA><AUTHOR></AUTHOR><CREATE_TIME>2023-01-02</CREATE_TIME><RECORD><KHBH>xj1702101129100001</KHBH><GDDH>15000265235</GDDH><SSZZJG_DM>1911071636050001</SSZZJG_DM><SJ_KHBH></SJ_KHBH><KHMC_PYT></KHMC_PYT><YZBM></YZBM><YDDH>15000265235</YDDH><LXR>阳永桥</LXR><SSSWJG_DM>1310226</SSSWJG_DM><GSZGRY_DM>2106181057340001</GSZGRY_DM><KHBM></KHBM><DH3></DH3><SSXZQH_DM>310120</SSXZQH_DM><KHYH></KHYH><KHMC>上海沿鹤液压器材有限公司</KHMC><KHSH>91310120MA1HLQRR2B</KHSH><SSZZJG_MC>光明办事处</SSZZJG_MC><YHZH></YHZH><SSSWJG_MC>上海市奉贤区税务局</SSSWJG_MC><KHLX_DM>11</KHLX_DM><GSZGRY_MC>张淑芬</GSZGRY_MC><TXDZ>青村镇奉永路399号</TXDZ></RECORD></DATA>");
    }

    @RequestMapping("aa")
    public void aa() {
        student.talk();
    }

    @RequestMapping("nums")
    @ResponseBody
    public void hello(int actIds, @RequestParam("bookName") int bookName, int... nums) {
        System.out.println(actIds);
        System.out.println(bookName);
        System.out.println(Arrays.toString(nums));
    }

    @RequestMapping("message")
    @ResponseBody
    public void message(String message) {
        log.info("message is: {}", message);
    }


    @PostMapping("/process/checkStatus/{processType}/{checkTime}")
    public BaseStatusResponseDto processFlowCallback(@PathVariable String processType, @PathVariable String result, @RequestBody ProcessCallbackDto processCallbackDto) {
        BaseStatusResponseDto responseDto = new BaseStatusResponseDto();
        return responseDto;
    }
}
