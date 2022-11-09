package com.springboot.live_comm.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beans.xml")
//加载xml文件的类可以是随意的一个Configuration类
public class Beans {


}
