package com.springboot.live_comm.configs;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler {
//    thymeleaf文件 且与静态资源访问无关（）
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e)throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","文件大小超出最大限制");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
