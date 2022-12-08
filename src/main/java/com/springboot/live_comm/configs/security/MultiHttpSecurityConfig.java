package com.springboot.live_comm.configs.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    在spring项目启动时会自动的执行一次Autowired注解的方法（最高优先级）
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("123").roles("ADMIN1", "DBA")
                .and()
                .withUser("admin").password("123").roles("ADMIN", "USER")
                .and()
                .withUser("zty").password("123").roles("ADMIN1");
    }

    @Configuration
//            优先级数字越小优先级越大,不写，优先级最小(为100，项目中多个类类继承相同的配置类时需要添加ORDER标签，否则会应该order的值都是100而报错)
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("*****************configure11*******************");
            http.antMatcher("/admin/**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN");
        }
    }
    @Configuration
//            优先级数字越小优先级越大,不写，优先级最小(为100，项目中多个类类继承相同的配置类时需要添加ORDER标签，否则会应该order的值都是100而报错)
    @Order(2)
    public static class Admin1SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("*****************configure22*******************");
            http.antMatcher("/admin1/**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN1");
        }
    }

    //                    一个项目中只能设置一个formLogin
    @Configuration
    @Order(3)
    public static class OtherSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            System.out.println("*****************configure33*******************");
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/login")
                    .usernameParameter("name")
                    .passwordParameter("password")
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
                    .and()
                    .csrf()
                    .disable();
        }
    }

}
