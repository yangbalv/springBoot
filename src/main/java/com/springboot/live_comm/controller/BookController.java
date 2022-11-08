package com.springboot.live_comm.controller;

import com.springboot.live_comm.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    Book book;

    @GetMapping(value = "/book")
    public String book() {
        System.out.println(book);
        return book.toString();
    }

    @GetMapping(value = "/book1")
    public Book book1() {
        Book book = new Book();
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        book.setPrice(30f);
        book.setPublicationDate(new Date());
        return book;
    }

    @GetMapping(value = "/books")
    public ModelAndView books() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("三国演义");
        book1.setAuthor("罗贯中");
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("红楼梦");
        book2.setAuthor("曹雪芹");
        books.add(book1);
        books.add(book2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("books1");
        return modelAndView;
    }

    @GetMapping(value = "/books2")
    public ModelAndView books2() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("三国演义");
        book1.setAuthor("罗贯中");
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("红楼梦");
        book2.setAuthor("曹雪芹");
        books.add(book1);
        books.add(book2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("books2");
        return modelAndView;
    }
}
