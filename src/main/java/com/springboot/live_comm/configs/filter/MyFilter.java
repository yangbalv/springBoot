package com.springboot.live_comm.configs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass().getName() + ">>> init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.getClass().getName() + ">>> doFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + ">>> destroy");
    }
}
