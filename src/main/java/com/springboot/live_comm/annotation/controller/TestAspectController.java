package com.springboot.live_comm.annotation.controller;


import com.springboot.live_comm.annotation.interfaces.MyLog;
import com.springboot.live_comm.annotation.interfaces.StartAndEndInstructions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestAspectController {
    @MyLog
    @StartAndEndInstructions()
    @RequestMapping("/add")
    public String add() {
        return "addyes";
    }

    @RequestMapping("/del")
    public String del() {


        return "delyes";
    }


    @RequestMapping("/upd")
    public String upd() {

        return "updyes";
    }


    @RequestMapping("/list")
    public String list() {
        return "listyes";
    }


}