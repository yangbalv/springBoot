package com.springboot.live_comm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//注册拦截器
public class MyInterceptor1 implements HandlerInterceptor {
//    顺序preHandle-》postHandle-》afterCompletion，若preHandle返回false则后续的都不会执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("MyInterceptor1 >>> preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("MyInterceptor1 >>> postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("MyInterceptor1 >>> afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
