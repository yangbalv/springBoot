package com.springboot.live_comm.annotation.controller;

import com.springboot.live_comm.annotation.interfaces.InterfaceForAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.zip.DataFormatException;

@RestController
@Slf4j
@RequestMapping("cfw")
public class ControllerForAnnotation {
    @InterfaceForAnnotation
    @RequestMapping("annotationMethod1")
    public void withinMethod1() {
        log.info("annotationMethod1");
    }

    @InterfaceForAnnotation
    @RequestMapping("annotationMethod2")
    private void withinMethod2() {
        log.info("annotationMethod2");
    }

    @RequestMapping("annotationMethod3")
    @InterfaceForAnnotation
    public void withinMethod3() throws IOException {
        log.info("annotationMethod3");
    }

    @RequestMapping("annotationMethod4")
    @InterfaceForAnnotation
    public void withinMethod4() throws IOException, DataFormatException {
        log.info("annotationMethod4");
    }

    @InterfaceForAnnotation
    @RequestMapping("annotationMethod5")
    public void withinMethod5() {
        log.info("annotationMethod5");
    }

    @InterfaceForAnnotation
    @RequestMapping("annotationMethod6")
    public void withinMethod6() {
        log.info("annotationMethod6");
    }
}
