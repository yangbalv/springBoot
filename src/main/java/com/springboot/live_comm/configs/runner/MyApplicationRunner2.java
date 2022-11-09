package com.springboot.live_comm.configs.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Order(2)
public class MyApplicationRunner2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("2-nonOptionArgs>>>" + nonOptionArgs);
//        以--name=zty为原型的输入会被捕获
        Set<String> optionNames = args.getOptionNames();
        for (String optionName : optionNames) {
            System.out.println("2-key:" + optionName + ";value:" + args.getOptionValues(optionName));
        }
    }
}
