package com.springboot.live_comm.controller.dh;

import com.springboot.live_comm.utils.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@ResponseBody
@RequestMapping("/dh")
@CrossOrigin
@Slf4j
public class JenkinsSystemController {

    @GetMapping("/{system}")
    public void jenkins(@PathVariable String system) throws IOException {
        String systemValue = SystemEnums.valueOf(system).getKey();
        String path = "http://183.195.144.230:9503/dhjk/view/dhbailian-publish/job/" + systemValue +
                "/buildWithParameters?token=qwertyui&branch=feat/dh2.2_dependency_cleanup&deploy_env=dh2dev";
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.getHTML(path);
    }

    @GetMapping("/all")
    public void jenkinsAll() throws IOException {
        for (SystemEnums value : SystemEnums.values()) {
            String path = "http://183.195.144.230:9503/dhjk/view/dhbailian-publish/job/" + value.getKey() +
                    "/buildWithParameters?token=qwertyui&branch=feat/dh2.2_dependency_cleanup&deploy_env=dh2dev";
            HttpUtil httpUtil = new HttpUtil();
            httpUtil.getHTML(path);
        }
    }
}
