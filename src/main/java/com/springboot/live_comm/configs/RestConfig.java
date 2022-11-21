package com.springboot.live_comm.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {
    //    设置rest的配置优先级高于application.properties文件的配置
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setDefaultPageSize(2)
                .setPageParamName("page")
                .setLimitParamName("size")
                .setSortParamName("sort")
                .setBasePath("/appp")
                .setReturnBodyOnCreate(true)
                .setReturnBodyOnUpdate(true);
//        super.configureRepositoryRestConfiguration(config);

    }
}
