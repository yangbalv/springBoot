package com.springboot.live_comm.controller;

import com.springboot.live_comm.dto.user.RegisterRequest;
import com.springboot.live_comm.dto.user.RegisterResponse;
import com.springboot.live_comm.entity.security.User;
import com.springboot.live_comm.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponse register(RegisterRequest request) throws Exception {
        RegisterResponse response = new RegisterResponse();
        System.out.println(request.toString());
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Integer num = userService.addUser(user);
        System.out.println(num);
        if (1 != num) {
            throw new Exception();
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView register(String username) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chat");
        modelAndView.addObject("username", username);
        return modelAndView;
    }
}
