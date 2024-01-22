package com.springboot.live_comm.controller.dh;

import com.springboot.live_comm.utils.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@ResponseBody
@RequestMapping("/dh")
@CrossOrigin
@Slf4j
public class JenkinsSystemController {

    @Value("${dh.jkpath}")
    private String jkpath;

    @GetMapping("/pu/{system}")
    public String puJenkins(@PathVariable String system) throws IOException {
        if ("publishAll".equals(system)) {
            for (SystemEnums value : SystemEnums.values()) {
                String path = jkpath + value.getPublish() +
                        "/buildWithParameters?token=qwertyui&branch=test/dh2.2dev&deploy_env=dh2dev";
                HttpUtil httpUtil = new HttpUtil();
                System.out.println(httpUtil.getHTML(path));
            }
            return "调用jenkins发布全部应用成功，详情去 （" + jkpath + "） 页面查看";
        } else {
            String systemValue = SystemEnums.valueOf(system).getPublish();
            String path = jkpath + systemValue +
                    "/buildWithParameters?token=qwertyui&branch=test/dh2.2dev&deploy_env=dh2dev";
            HttpUtil httpUtil = new HttpUtil();
            System.out.println(httpUtil.getHTML(path));
            return "发布" + system + "应用成功，详情在 （" + jkpath + "） 页面查看";
        }
    }

    @GetMapping("/de/{system}")
    public String deJenkins(@PathVariable String system) throws IOException {
        String systemValue = SystemEnums.valueOf(system).getDeploy();
        String path = jkpath + systemValue +
                "/buildWithParameters?token=qwertyui&branch=feat/dh2.2_dependency_cleanup&deploy_env=dh2dev";
        HttpUtil httpUtil = new HttpUtil();
        System.out.println(httpUtil.getHTML(path));
        return "deploy" + system + "应用成功，详情去 （" + jkpath + "） 页面查看";
    }
}
