package com.springboot.live_comm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.live_comm.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//去除某项启动配置项
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ServletComponentScan
////开启缓存
@EnableCaching
public class MyGoodSpringBoot {
    public static void main(String[] args) {
//        SpringApplicationBuilder builder = new SpringApplicationBuilder();
//        builder.bannerMode(Banner.Mode.OFF).run(args);
//        devtools关闭自动重启
//        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(MyGoodSpringBoot.class, args);
        JSONObject.toJavaObject(JSON.parseObject(""), Book.class);
    }
}
