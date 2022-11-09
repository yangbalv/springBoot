package com.springboot.live_comm;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class App {
    public static void main(String[] args) {
//        SpringApplicationBuilder builder = new SpringApplicationBuilder();
//        builder.bannerMode(Banner.Mode.OFF).run(args);
        SpringApplication.run(App.class, args);
    }
}
