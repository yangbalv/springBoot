package com.springboot.live_comm;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//去除某项启动配置项
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ServletComponentScan
////开启缓存
//@EnableCaching
public class App {
    public static void main(String[] args) {
//        SpringApplicationBuilder builder = new SpringApplicationBuilder();
//        builder.bannerMode(Banner.Mode.OFF).run(args);
//        devtools关闭自动重启
//        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(App.class, args);
    }
}
