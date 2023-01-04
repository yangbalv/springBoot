package com.springboot.live_comm.configs;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.live_comm.interceptor.MyInterceptor1;
//import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
//@MapperScan("com.springboot.live_comm.mappers")//表明该包下所有的接口都是mapper（多元数据库测不能使用这个方法进行mapper的扫描）
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
//        下面两个同时写时文件从classpath:/下获取
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");//指向classpath:\下的文件(除了resources\META-INF下的文件都会放到classpath:\下)
        registry.addResourceHandler("/**").addResourceLocations("/");//指向resources\META-INF\resources下的文件

//        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");由于进行了配置（/**-》classpath:/）不需要再进行public的配置
        registry.addResourceHandler("/resource/**").addResourceLocations("classpath:/static/"); //个例配置优先级大于一般配置访问resource也是去static下面寻找文件
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
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

    //注册拦截器
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

    //路径映射（根据项目配置的视图层技术，去视图层技术的指定目录下查找并返回文件，与静态资源访问）
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }
}
