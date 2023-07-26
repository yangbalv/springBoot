package com.springboot.live_comm.annotation.controller;

import com.springboot.live_comm.annotation.interfaces.InterfaceForArgsX;
import com.springboot.live_comm.annotation.interfaces.InterfaceForWithX;
import com.springboot.live_comm.annotation.interfaces.StartAndEndInstructions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.zip.DataFormatException;

@RestController
@Slf4j
@RequestMapping("cfw")
@InterfaceForWithX
@InterfaceForArgsX
public class ControllerForWithinX {
    @RequestMapping("withinXMethod1")
    public void withinMethod1() {
        log.info("withinXMethod1");
    }

    @RequestMapping("withinXMethod2")
    private void withinMethod2() {
        log.info("withinXMethod2");
    }

    @RequestMapping("withinXMethod3")

    public void withinMethod3() throws IOException {
        log.info("withinXMethod3");
    }

    @RequestMapping("withinXMethod4")
    public void withinMethod4() throws IOException, DataFormatException {
        log.info("withinXMethod4");
    }

    @RequestMapping("withinXMethod5")
    public void withinMethod5(String aa) {
        log.info("withinXMethod5");
    }


    @RequestMapping("withinXMethod6")
    public void withinMethod6(String aa, int bb) {
        log.info("withinXMethod6");
    }

    @RequestMapping("withinXMethod7")
    public void withinMethod7(int bb) {
        log.info("withinXMethod7");
    }

    @RequestMapping("withinXMethod8")
    public void withinMethod8(@InterfaceForArgsX int bb) {
        log.info("withinXMethod8");
    }
}
