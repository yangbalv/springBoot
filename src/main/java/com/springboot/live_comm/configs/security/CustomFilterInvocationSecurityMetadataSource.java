package com.springboot.live_comm.configs.security;

import com.springboot.live_comm.entity.security.Menu;
import com.springboot.live_comm.entity.security.Role;
import com.springboot.live_comm.mappers.mybatiss1.MenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
//访问的当前的url需要的用户角色
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${tencentCloud.h5FaceCore.webankAppId}")
    private static String serverServletContextPath;
    public static final String PUBLIC_INDEX_URL = "/";
    public static final String PUBLIC_LOGIN_URL = "/login";
    public static final String PUBLIC_REGISTER_URL = "/register";
    public static final String PUBLIC_RESOURCE_URL = "/public/**";
    public static final String TEST_URL = "/test/**";
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    MenuMapper menuMapper;


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        logger.info("requestUrl is: {}", requestUrl);
//        System.out.println("requestUrl is: " + requestUrl);
        if (PUBLIC_INDEX_URL.equals(requestUrl) ||
                PUBLIC_LOGIN_URL.equals(requestUrl) ||
                PUBLIC_REGISTER_URL.equals(requestUrl) ||
                antPathMatcher.match(PUBLIC_RESOURCE_URL, requestUrl) ||
                antPathMatcher.match(TEST_URL, requestUrl) ||
                (serverServletContextPath + PUBLIC_INDEX_URL).equals(requestUrl) ||
                (serverServletContextPath + PUBLIC_LOGIN_URL).equals(requestUrl) ||
                (serverServletContextPath + PUBLIC_REGISTER_URL).equals(requestUrl) ||
                antPathMatcher.match(serverServletContextPath + PUBLIC_RESOURCE_URL, requestUrl) ||
                antPathMatcher.match(serverServletContextPath + TEST_URL, requestUrl)
        ) {

            return null;
        }
        List<Menu> allMenus = menuMapper.getAllMenus();
        for (Menu menu : allMenus) {
            if (antPathMatcher.match(menu.getPattern(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleArr = new String[roles.size()];
                for (int i = 0; i < roleArr.length; i++) {
                    roleArr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
