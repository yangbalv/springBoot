package com.springboot.live_comm.controller.book;

import com.springboot.live_comm.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("/corsBook")
public class CORSBookController {
    @Autowired
    Book book;
//    cros特殊配置优先生效以下的配置addBook只接受来自localhost:8081的转发，deleteBookById只接受localhost:8080的转发，getBook接受的转发与WebMvcConfigurer相同的转发
    @PostMapping("/")
//    @CrossOrigin(value = "http://localhost:8081", maxAge = 10, allowedHeaders = "*")
    public String addBook(String name) {
        return "receive" + name;
    }

    @CrossOrigin(value = "*",maxAge = 10, allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }
//    由于WebMvcConfigurer中设置了全局的跨域资源，所以/corsBook/**下所有的接口都被拦截只有localhost:8081的请求支持跨域，这里又将其设置成*则解除了跨域的限制
    @CrossOrigin(value = "*",maxAge = 10, allowedHeaders = "*")
    @RequestMapping(value = "/getBook")
    public String getBook() {
        return book.toString();
    }

}
