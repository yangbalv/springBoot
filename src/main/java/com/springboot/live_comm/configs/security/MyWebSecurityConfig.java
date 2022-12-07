package com.springboot.live_comm.configs.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//基于内存的认证（设置了这个则application中设置的会失效）
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    //    密码加密方式
    @Bean
    PasswordEncoder passwordEncoder() {
//        不加密
        return NoOpPasswordEncoder.getInstance();
    }

    //    设置用户(账户密码、权限)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("123").roles("ADMIN", "DBA")
                .and()
                .withUser("admin").password("123").roles("ADMIN", "USER")
                .and()
                .withUser("zty").password("123").roles("USER");
    }

    //    springSecurity配置之后默认会修改/login接口的get与post请求方式get作为验证登录的界面，post作为验证登陆的接口
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表示开启HttpSecurity配置
        http.authorizeRequests()
//                配置了ADMIN权限用户可以访问/admin/**下的接口
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
//                配置了ADMIN或USER权限用户可以访问/user/**下的接口
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')")
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')")
//               除了上面配置的接口外所有的接口都需要登录
                .anyRequest()
                .authenticated()

//登录表单详细配置
                .and()
                .formLogin()
//                登陆前跳转页面（未授权请求接口）()
//                若不设置此属性则会重新设置/login接口，变为Security的默认登录页面设置之后，未授权的请求会跳转到这个接口
//                .loginPage("/login")
//               登录请求接口（修改了请求的名称而已）即授权接口就是这个接口应该也会覆盖已写的接口（未授权时需要以post请求方式向这个接口发送登录数据（from-data形式））（这里的设置应该是防止与项目中其他的接口冲突）
                .loginProcessingUrl("/loginSecurity")


//自定义验证接口的请求参数的名称即loginProcessingUrl接受的名称
                .usernameParameter("name")
                .passwordParameter("password")
//                设置登录成功的返回
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
                //                设置登录失败的返回
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
                .logout()
//                默认覆盖 /logout接口的service方法
//                重新设置logout 的接口名称
                .logoutUrl("/logout")
//                清楚身份信息,默认为true
                .clearAuthentication(true)
//                使session失效，默认也为true
                .invalidateHttpSession(true)
//                注销操作设置
                .addLogoutHandler(new LogoutHandler() {
                                      @Override
                                      public void logout(HttpServletRequest httpServletRequest,
                                                         HttpServletResponse httpServletResponse,
                                                         Authentication authentication) {

                                      }
                                  }
                )
//                注销成功后操作设置
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse,
                                                Authentication authentication) throws IOException, ServletException {
//                        设置注销成功的重定向
                        httpServletResponse.sendRedirect("/login");
                    }
                })
                .and()
                .csrf()
                .disable();

    }
}
