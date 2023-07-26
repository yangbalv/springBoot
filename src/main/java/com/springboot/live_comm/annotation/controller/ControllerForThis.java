package com.springboot.live_comm.annotation.controller;

import com.springboot.live_comm.annotation.interfaces.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.zip.DataFormatException;

@RestController
@Slf4j
@RequestMapping("cfw")
public class ControllerForThis implements Action {
    @RequestMapping("thisMethod1")
    public void thisMethod1() {
        log.info("thisMethod1");
    }

    @RequestMapping("thisMethod2")
    private void thisMethod2() {
        log.info("thisMethod2");
    }

    @RequestMapping("thisMethod3")
    public void thisMethod3() throws IOException {
        log.info("thisMethod3");
    }

    @RequestMapping("thisMethod4")
    public void thisMethod4() throws IOException, DataFormatException {
        log.info("thisMethod4");
    }

    @RequestMapping("thisMethod5")
    public void thisMethod5() {
        log.info("thisMethod5");
    }

    @Override
    @RequestMapping("thisMethod6")
    public void sign() {
        log.info("thisMethod6");
    }
}
