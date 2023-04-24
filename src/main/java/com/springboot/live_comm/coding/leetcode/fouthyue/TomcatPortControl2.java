package com.springboot.live_comm.coding.leetcode.fouthyue;




import org.apache.catalina.startup.Tomcat;

public class TomcatPortControl2 {
    public static void main(String[] args) {  
        try {  
            // 创建Tomcat对象  
            Tomcat tomcat = new Tomcat();
  
            // 设置端口号  
            tomcat.setPort(8080);  
  
            // 启动Tomcat  
            tomcat.start();  
  
            // 获取端口号  
            int port = tomcat.getConnector().getPort();
  
            // 输出端口号  
            System.out.println("Port is " + port);  
  
            // 关闭Tomcat  
            tomcat.stop();  
        } catch (Exception e) {
            e.printStackTrace();  
        }  
    }  
}