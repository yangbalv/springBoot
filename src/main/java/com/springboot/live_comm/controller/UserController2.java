package com.springboot.live_comm.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Scanner;

public class UserController2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Parameter属性就是拼接在url后面的
        System.out.println("url中的连接的数据(参数): " + req.getParameter("name"));
        System.out.println("参数的名字有: " + (String) req.getParameterNames().nextElement());

        System.out.println("根据名称获取请求头得到的第一个结果: " + req.getHeader("名称"));
        System.out.println("请求头的名称有：" + req.getHeaderNames().toString());
        System.out.println("根据名称获取请求头的结果集: " + req.getHeaders("name").nextElement());

        System.out.println("请求的Url: " + req.getRequestURL().toString());
        System.out.println("url后面串联的原始数据: " + req.getQueryString());
        System.out.println("请求的接口： " + req.getRequestURI());
        System.out.println("接口的名称: " + req.getServletPath());


        System.out.println("请求的内容的地址（除去当前接口）" + req.getContextPath());
        System.out.println("post 的body的类型（json,text）: " + req.getContentType());
        System.out.println("post 的body的长度: " + req.getContentLength());
        System.out.println("post 的body的长度: (long)" + req.getContentLengthLong());

        System.out.println("本机的电脑（服务器）的IP: " + req.getLocalAddr());
        System.out.println("本机的电脑（服务器）的名称： " + req.getLocalName());
        System.out.println("请求的端口（服务器的端口）: " + req.getLocalPort());
        System.out.println("本机的IP: " + req.getServerName());
        System.out.println("当前服务的端口: " + req.getServerPort());
        System.out.println("请求者（客户端）的所在地址（国家的对应的代码）: " + req.getLocale().toString());

        System.out.println("请求者（客户端）的电脑IP:  " + req.getRemoteAddr());
        System.out.println("*****获取远程端口(请求者的端口): " + req.getRemotePort());
        System.out.println("请求方式: " + req.getMethod());
        System.out.println("请求的协议: " + req.getProtocol());
        System.out.println("协议的名称: " + req.getScheme());

        System.out.println("session is: " + req.getSession().toString());
        System.out.println("调度程序类型: " + req.getDispatcherType().toString());
        System.out.println("获取输入流： " + req.getInputStream().toString());
        System.out.println("属性: " + req.getAttributeNames().toString());

        Enumeration values1 = req.getParameterNames();
        System.out.println("请求参数有 :");
        while (values1.hasMoreElements()) {
            String name = (String) values1.nextElement();
            String value = req.getParameterValues(name)[0];
            System.out.println("请求参数中对应的 name is :" + name + ", 对应的数据是: " + value);
        }
        System.out.println("__________分割线__________");


        Enumeration values2 = req.getAttributeNames();

        System.out.println("请求的属性有 :");
        while (values2.hasMoreElements()) {
            String name = (String) values2.nextElement();
            String value = (String) req.getAttribute(name);

            System.out.println("请求的属性中对应的 name is :" + name + ", 对应的数据是: " + value);
        }
        System.out.println("__________分割线__________");


        Enumeration values3 = req.getHeaderNames();

        System.out.println("请求头有: ");
        while (values3.hasMoreElements()) {
            String name = (String) values3.nextElement();
            String value = req.getHeaders(name).nextElement();
            System.out.println("请求头中对应的 name is :" + name + ", 对应的数据是: " + value);
        }
        System.out.println("__________分割线__________");


        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        Scanner scanner = new Scanner(reader);
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNextLine()) {
            stringBuffer.append(scanner.nextLine());
        }
        System.out.println("请求的body的原始数据: " + stringBuffer);

    }



}
