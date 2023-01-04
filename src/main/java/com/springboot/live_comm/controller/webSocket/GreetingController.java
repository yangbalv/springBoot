package com.springboot.live_comm.controller.webSocket;

import com.springboot.live_comm.dto.webSocket.Chat;
import com.springboot.live_comm.dto.webSocket.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class GreetingController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
        System.out.println(message);
        return message;
    }

    @MessageMapping("/hello1")
    public Message greeting1(Message message) throws Exception {
        System.out.println(message);
//        不使用@SendTo注解进行消费发送
        simpMessagingTemplate.convertAndSend("/topic/greetings", message);
        return message;
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) throws Exception {
        System.out.println(principal);
        System.out.println(chat);
        String from = principal.getName();
        chat.setFrom(from);
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }
}
