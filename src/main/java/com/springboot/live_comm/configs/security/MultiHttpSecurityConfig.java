package com.springboot.live_comm.configs.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.live_comm.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//配置多个HttpSecurity
//无需继承WebSecurityConfigurerAdapter
@Configuration
public class MultiHttpSecurityConfig {
    @Autowired
    UserService userService;

    //密码加密方式
    @Bean
    PasswordEncoder passwordEncoder() {
//        强hash函数，strength为密文迭代次数（取值范围为4-31，默认10）（相同的密码也会加密成不同的密文）
        return new BCryptPasswordEncoder(10);
    }

    //    在spring项目启动时会自动的执行一次Autowired注解的方法（最高优先级）
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
//        auth.inMemoryAuthentication()
//                .withUser("root").password("123").roles("ADMIN1", "DBA")
//                .and()
////                设置了加密之后配置的密码也是加密之后的密文
//                .withUser("admin").password("$2a$10$2e8tTSk7CZiKUUiniKjzbuCGfp0/4vEDflBz8c6YzVd4b3P1g8pQ.").roles("ADMIN", "USER")
//                .and()
//                .withUser("zty").password("$2a$10$Pa8lMflBy0v2RPqLzc6haOPXj/WbLsCtJKwSc3KNkj5a7NmW9YUre").roles("ADMIN1");
    }

    @Configuration
//            优先级数字越小优先级越大,不写，优先级最小(为100，项目中多个类类继承相同的配置类时需要添加ORDER标签，否则会应该order的值都是100而报错)
    @Order(5)
    public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("*****************configure11*******************");
            http.antMatcher("/user/**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("user");
        }
    }

    @Configuration
//            优先级数字越小优先级越大,不写，优先级最小(为100，项目中多个类类继承相同的配置类时需要添加ORDER标签，否则会应该order的值都是100而报错)
    @Order(2)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("*****************configure22*******************");
            http.antMatcher("/admin/**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("admin");
        }
    }

    @Configuration
//            优先级数字越小优先级越大,不写，优先级最小(为100，项目中多个类类继承相同的配置类时需要添加ORDER标签，否则会应该order的值都是100而报错)
    @Order(10)
    public static class DBASecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("*****************configure22*******************");
            http.antMatcher("/dba/**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("dba");
        }
    }

    //                    一个项目中只能设置一个formLogin
    @Configuration
    @Order(1)
    public static class OtherSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("*****************configure33*******************");
            http.authorizeRequests()
                    .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                        @Override
                        public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                            object.setSecurityMetadataSource(cfisms());
                            object.setAccessDecisionManager(cadm());
                            return object;
                        }
                    })

                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/login")
//                    .usernameParameter("name")
//                    .passwordParameter("password")
                    .permitAll()
                    .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest req,
                                                            HttpServletResponse resp,
                                                            Authentication auth)
                                throws IOException, ServletException {
//                        获取登录用户信息
                            Object principal = auth.getPrincipal();
//                        设置返回格式
                            resp.setContentType("application/json;charset=utf-8");

                            PrintWriter out = resp.getWriter();
//                        设置请求状态
                            resp.setStatus(200);
                            Map<String, Object> map = new HashMap<>();
//                        添加返回数据
                            map.put("status", 200);
                            map.put("msg", principal);
                            ObjectMapper om = new ObjectMapper();
//                        写数据
                            out.write(om.writeValueAsString(map));
                            out.flush();
                            out.close();
                        }
                    })
                    .failureHandler(new AuthenticationFailureHandler() {
                        @Override
                        public void onAuthenticationFailure(HttpServletRequest req,
                                                            HttpServletResponse resp,
                                                            AuthenticationException e)
                                throws IOException, ServletException {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            resp.setStatus(401);
                            Map<String, Object> map = new HashMap<>();
                            map.put("status", 401);
//                        判断抛出的异常
                            if (e instanceof LockedException) {
                                map.put("msg", "账户被锁定，登录失败！");
                            } else if (e instanceof BadCredentialsException) {
                                map.put("msg", "账户名或者密码输入错误，登录失败！");
                            } else if (e instanceof DisabledException) {
                                map.put("msg", "用户被禁用，登录失败！");
                            } else if (e instanceof AccountExpiredException) {
                                map.put("msg", "账户已过期，登录失败！");
                            } else if (e instanceof CredentialsExpiredException) {
                                map.put("msg", "密码已过期，登录失败！");
                            } else {
                                map.put("msg", "登录失败！");
                            }
                            ObjectMapper om = new ObjectMapper();
                            out.write(om.writeValueAsString(map));
                            out.flush();
                            out.close();
                        }
                    })
                    .permitAll()
                    .and()
                    .csrf()
                    .disable();
        }

        //    角色所属关系管理
        @Bean
        RoleHierarchy roleHierarchy() {
            RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        ROLE_后面的就是数据库中对应的存储的用户权限的数据，例如ROLE_admin在做权限管理时代表admin，ROLE_ADMIN代表ADMIN
            String hierarchy = "ROLE_dba > ROLE_admin ROLE_admin > ROLE_user";
            roleHierarchy.setHierarchy(hierarchy);
            return roleHierarchy;
        }

        //设置bean(访问的当前的url需要的用户角色)
        @Bean
        CustomFilterInvocationSecurityMetadataSource cfisms() {
            return new CustomFilterInvocationSecurityMetadataSource();
        }

        //设置bean(判断用户是否具备 访问的当前的url需要的用户角色)
        @Bean
        CustomAccessDecisionManager cadm() {
            return new CustomAccessDecisionManager();
        }

    }

}
