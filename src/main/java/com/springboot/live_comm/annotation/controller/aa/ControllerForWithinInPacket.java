package com.springboot.live_comm.annotation.controller.aa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.zip.DataFormatException;

@RestController
@Slf4j
@RequestMapping("cfwip")
public class ControllerForWithinInPacket {
    @RequestMapping("withinMethod1")
    public void withinMethod1() {
        log.info("withinMethod1");
    }

    @RequestMapping("withinMethod2")
    private void withinMethod2() {
        log.info("withinMethod2");
    }

    @RequestMapping("withinMethod3")
    public void withinMethod3() throws IOException {
        log.info("withinMethod3");
    }

    @RequestMapping("withinMethod4")
    public void withinMethod4() throws IOException, DataFormatException {
        log.info("withinMethod4");
    }

    @RequestMapping("withinMethod5")
    public void withinMethod5() {
        log.info("withinMethod5");
    }

    @RequestMapping("withinMethod6")
    public void withinMethod6() {
        log.info("withinMethod6");
    }
}
