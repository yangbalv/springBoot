package com.springboot.live_comm.controller.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityHelloController {
    @GetMapping("/securityHello")
    public String hello() {
        return "hello";
    }
}
