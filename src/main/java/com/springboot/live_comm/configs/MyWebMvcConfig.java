package com.springboot.live_comm.configs;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.live_comm.interceptor.MyInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

//    fastJSon配置
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////        fastJson 的另一种配置方式(添加到converters中)  (不能同时配置)
//        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setDateFormat("yyyy");
//        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.WriteClassName,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteNullStringAsEmpty
//        );
//        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastJsonConverter);
//    }

    //    静态资源访问
//    http://localhost:8080/static/p1.png即访问classpath:/static/p1.png
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    //cors跨域访问配置，访问/corsBook/**的子路径时进行了配置，所有的请求头，所有的请求方式，跨域的有效期为1800秒，支持来自localhost://8080的请求
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/corsBook/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(10)
                .allowedOrigins("http://localhost:8081");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1())
                .addPathPatterns("/**")//被拦截的
                .excludePathPatterns(//不被拦截的
                        "/hello",//单个路径
                        "/path/**",//以某个路径开始
                        "/**/hello",//以某个路径结尾
                        "/**/hello2/**");//包涵某个路径
    }
}
