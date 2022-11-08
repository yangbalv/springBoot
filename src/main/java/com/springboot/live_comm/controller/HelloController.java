package com.springboot.live_comm.controller;

import com.springboot.live_comm.model.Book;
import com.springboot.live_comm.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    @ResponseBody
    public void hello(Model model) {
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
}
