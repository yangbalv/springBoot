package com.springboot.live_comm.annotation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.zip.DataFormatException;

@RestController
@Slf4j
@RequestMapping("cfe")
public class ControllerForExecution {
    @RequestMapping("executionMethod1")
    public void executionMethod1() {
        log.info("executionMethod1");
    }

    @RequestMapping("executionMethod2")
    private void executionMethod2() {
        log.info("executionMethod2");
    }

    @RequestMapping("executionMethod3")
    public void executionMethod3() throws IOException {
        log.info("executionMethod4");
    }

    @RequestMapping("executionMethod4")
    public void executionMethod4() throws IOException, DataFormatException  {
        log.info("executionMethod4");
    }

    @RequestMapping("executionMethod5")
    public void executionMethod5()  {
        log.info("executionMethod5");
    }

    @RequestMapping("executionMethod6")
    public void executionMethod6() {
        log.info("executionMethod6");
    }
}
