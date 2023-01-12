package com.springboot.live_comm.configs.listener.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.springboot.live_comm.entity.security.User;
import com.springboot.live_comm.services.security.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//启动类加上注解@ServletComponentScan，这样才能扫描到监听器
@Component
@WebListener
public class MySessionListner implements HttpSessionListener {

    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(MySessionListner.class);

    /**
     * 新建session时（打开浏览器访问登录页面时，服务器会创建一个新的session）
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {


    }

    /**
     * 删除session时（退出系统）
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("销毁session时");

        HttpSession session = httpSessionEvent.getSession();
        User user = (User) session.getAttribute("loginUser");
        if (user != null) {
            System.out.println("用户【" + user.getUsername() + "】登出了");
//            session失效时将用户解锁
            userService.unlockUser(user);
        } else {
            System.out.println("*************");
        }

    }

}