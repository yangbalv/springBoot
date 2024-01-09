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
    public String jenkins(@PathVariable String system) throws IOException {
        if ("publishAll".equals(system)){
            for (SystemEnums value : SystemEnums.values()) {
                String path = "http://183.195.144.230:9503/dhjk/view/dhbailian-publish/job/" + value.getKey() +
                        "/buildWithParameters?token=qwertyui&branch=feat/dh2.2_dependency_cleanup&deploy_env=dh2dev";
                HttpUtil httpUtil = new HttpUtil();
                httpUtil.getHTML(path);
            }
            return "调用jenkins发布全部应用未出现异常，详情去 （http://183.195.144.230:9503/dhjk/） 页面查看";
        }else {

            String systemValue = SystemEnums.valueOf(system).getKey();
            String path = "http://183.195.144.230:9503/dhjk/view/dhbailian-publish/job/" + systemValue +
                    "/buildWithParameters?token=qwertyui&branch=feat/dh2.2_dependency_cleanup&deploy_env=dh2dev";
            HttpUtil httpUtil = new HttpUtil();
            httpUtil.getHTML(path);
            return "调用jenkins发布"+system+"应用未出现异常，详情去 （http://183.195.144.230:9503/dhjk/） 页面查看";
        }
    }
}
