package com.springboot.live_comm.controllerConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

//完全自定义error情况(优先级小于特殊设置)(条件越明确优先级越高)
public class MyErrorController extends BasicErrorController {
    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);

    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        model.put("customMsg", "出错啦");
        ModelAndView modelAndView = new ModelAndView("MyErrorPage", model, status);
        return modelAndView;
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        body.put("customMsg", "出错啦");
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(body, status);
    }
}
