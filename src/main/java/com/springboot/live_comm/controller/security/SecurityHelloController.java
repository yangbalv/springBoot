package com.springboot.live_comm.controller.security;

import com.springboot.live_comm.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SecurityHelloController {
    @GetMapping(value = "/security/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/securityHello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/admin/securityHello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/user/securityHello")
    public String user() {
        return "hello";
    }

    @GetMapping("/db/securityHello")
    public String dba() {
        return "hello dba";
    }

}
