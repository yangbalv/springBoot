package com.springboot.live_comm.controller;

import com.springboot.live_comm.dto.user.RegisterRequest;
import com.springboot.live_comm.dto.user.RegisterResponse;
import com.springboot.live_comm.entity.security.User;
import com.springboot.live_comm.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    @RequestMapping(value = "/woodenFish", method = RequestMethod.GET)
    public ModelAndView woodenFish() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("woodenFish");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/chatRoom", method = RequestMethod.GET)
    public ModelAndView chat(HttpSession session) throws Exception {
        User loginUser = (User) session.getAttribute("loginUser");
        System.out.println("username+" + loginUser.getUsername());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", loginUser.getUsername());
        modelAndView.setViewName("chatRoom");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ModelAndView menu(HttpSession session) throws Exception {
        User loginUser = (User) session.getAttribute("loginUser");
        System.out.println("username+" + loginUser.getUsername());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", loginUser.getUsername());
        modelAndView.setViewName("menu");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/chatToSomeone", method = RequestMethod.GET)
    public ModelAndView chatToSomeone(HttpSession session) throws Exception {
        User loginUser = (User) session.getAttribute("loginUser");
        System.out.println("username+" + loginUser.getUsername());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", loginUser.getUsername());
        modelAndView.setViewName("chatToSomeone");
        return modelAndView;
    }
}
