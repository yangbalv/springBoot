package com.springboot.live_comm.configs;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalConfig {
    //    全局变量
    @ModelAttribute(value = "info")
    public Map<String, String> userInfo() {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", "罗贯中");
        userMap.put("gender", "男");
        return userMap;
    }
//    设置请求参数的属性
    @InitBinder("b")
    public void init(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }
    @InitBinder("a")
    public void init2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }
}
