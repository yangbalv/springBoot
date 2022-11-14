package com.springboot.live_comm.controller.book;

import com.springboot.live_comm.entity.Book;
import com.springboot.live_comm.mappers.mybatiss1.BookMapper;
import com.springboot.live_comm.mappers.mybatiss2.BookMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/mybatisS")
public class VersatileMybatisDataSourceBookController {
    @Autowired
    BookMapper bookMapper1;
    @Autowired
    BookMapper2 bookMapper2;

    @GetMapping("/test1")
    public void test1() {
        List<Book> books1 = bookMapper1.getAllBooks();
        List<Book> books2 = bookMapper2.getAllBooks();
        System.out.println("books1: " + books1);
        System.out.println("books2: " + books2);

    }
}
