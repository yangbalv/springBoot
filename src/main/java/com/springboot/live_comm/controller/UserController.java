package com.springboot.live_comm.controller;

import com.springboot.live_comm.dto.LoginResponseDto;
import com.springboot.live_comm.model.User;
import com.springboot.live_comm.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class UserController {
    public int t;
    @Autowired
    Users users;

    @GetMapping(value = "/users")
    public String users() {
        System.out.println(users);
        return users.toString();
    }

    @GetMapping(value = "/login")
    public LoginResponseDto login(String name, String password) {
        LoginResponseDto responseDto = new LoginResponseDto();
        System.out.println("*********************");
        System.out.println(name);
        System.out.println(password);
        responseDto.setSuccess(true);
        return responseDto;
    }

    public static void main(String[] args) {
        String s = "aa";
        String b = "bb";
        System.out.println(s.equals(b));

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserController) {
            UserController userController = (UserController) obj;
            if (userController.t == this.t) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
