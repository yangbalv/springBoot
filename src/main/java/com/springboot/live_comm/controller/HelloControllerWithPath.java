package com.springboot.live_comm.controller;

import com.springboot.live_comm.model.Book;
import com.springboot.live_comm.model.Hello;
import com.springboot.live_comm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.Scanner;

@Controller
@RequestMapping("/path")
public class HelloControllerWithPath {
    @Autowired
    Hello hello;

    //    @Resource可以看成Autowired+Qualifier
    @Autowired
    @Qualifier("book")
    Book book;
    @Resource(name = "book")
    Book book2;

    @RequestMapping(value = "/hello2")
    @ResponseBody
    public String hello2(Model model) {
        return book.toString() + book2.toString() + hello.sayHello();
    }

    @RequestMapping(value = "/hello2/hello3")
    @ResponseBody
    public String hello3(Model model) {
        return book.toString() + book2.toString() + hello.sayHello();
    }

    @GetMapping(value = "/hello")
    @ResponseBody
    public void hello(Model model) {
        Map<String, Object> map = model.asMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key is: " + entry.getKey() + ", value is:" + entry.getValue());
        }
    }
    @GetMapping(value = "/hello/oo/aa")
    @ResponseBody
    public void helloa(Model model) {
        Map<String, Object> map = model.asMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key is: " + entry.getKey() + ", value is:" + entry.getValue());
        }
    }

    @GetMapping(value = "/hello1")
    @ResponseBody
    public String ctrl(@ModelAttribute("b") Book book, @ModelAttribute("a") User user) {
        return book.toString() + user.toString();
    }

    @GetMapping(value = "/userInfo")
    @ResponseBody
    public String myInfo(HttpServletRequest req, HttpServletResponse res) throws IOException {
        StringBuilder result = new StringBuilder();
//        Parameter属性就是拼接在url后面的
        result.append("姓名: " + req.getParameter("name"));
        result.append("                      ");


        result.append("                      ");
        result.append("请求的Url: " + req.getRequestURL().toString());
        result.append("                      ");
        result.append("url后面串联的原始数据: " + req.getQueryString());
        result.append("                      ");
        result.append("请求的接口： " + req.getRequestURI());
        result.append("                      ");
        result.append("接口的名称: " + req.getServletPath());
        result.append("                      ");
        result.append("请求的内容的地址（除去当前接口）" + req.getContextPath());
        result.append("                      ");
        result.append("post 的body的类型（json,text）: " + req.getContentType());
        result.append("                      ");
        result.append("post 的body的长度: " + req.getContentLength());
        result.append("                      ");
        result.append("post 的body的长度: (long)" + req.getContentLengthLong());
        result.append("                      ");
        result.append("本机的电脑（服务器）的IP: " + req.getLocalAddr());
        result.append("                      ");
        result.append("本机的电脑（服务器）的名称： " + req.getLocalName());
        result.append("                      ");
        result.append("请求的端口（服务器的端口）: " + req.getLocalPort());
        result.append("                      ");
        result.append("本机的IP: " + req.getServerName());
        result.append("                      ");
        result.append("当前服务的端口: " + req.getServerPort());
        result.append("                      ");
        result.append("请求者（客户端）的所在地址（国家的对应的代码）: " + req.getLocale().toString());
        result.append("                      ");
        result.append("请求者（客户端）的电脑IP:  " + req.getRemoteAddr());
        result.append("                      ");
        result.append("*****获取远程端口(请求者的端口): " + req.getRemotePort());
        result.append("                      ");
        result.append("请求方式: " + req.getMethod());
        result.append("                      ");
        result.append("请求的协议: " + req.getProtocol());
        result.append("                      ");
        result.append("协议的名称: " + req.getScheme());
        result.append("                      ");
        result.append("session is: " + req.getSession().toString());
        result.append("                      ");
        result.append("调度程序类型: " + req.getDispatcherType().toString());
        result.append("                      ");
        result.append("获取输入流： " + req.getInputStream().toString());
        result.append("                      ");
        result.append("属性: " + req.getAttributeNames().toString());
        result.append("                      ");
        Enumeration values1 = req.getParameterNames();
        result.append("                      ");
        result.append("请求参数有 :");
        result.append("                      ");
        while (values1.hasMoreElements()) {
            String name = (String) values1.nextElement();
            String value = req.getParameterValues(name)[0];
            result.append("请求参数中对应的 name is :" + name + ", 对应的数据是: " + value);
        }

        result.append("__________分割线__________");
        result.append("                      ");
        Enumeration values3 = req.getHeaderNames();
        result.append("请求头有: ");
        while (values3.hasMoreElements()) {
            String name = (String) values3.nextElement();
            String value = req.getHeaders(name).nextElement();
            result.append("请求头中对应的 name is :" + name + ", 对应的数据是: " + value);
        }
        result.append("__________分割线__________");
        result.append("                      ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        Scanner scanner = new Scanner(reader);
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNextLine()) {
            stringBuffer.append(scanner.nextLine());
        }
        result.append("请求的body的原始数据: " + stringBuffer);
        result.append("                      ");
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aaa");
//        stringBuilder.append("\n");

        stringBuilder.append("bbb");
        System.out.println(stringBuilder.toString());
    }

}
