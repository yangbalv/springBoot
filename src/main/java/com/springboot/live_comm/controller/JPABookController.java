package com.springboot.live_comm.controller;



import com.springboot.live_comm.entity.JPABook;
import com.springboot.live_comm.services.JPABookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class JPABookController {
    @Autowired
    JPABookService jpaBookService;

    @GetMapping("/findAll")
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(2, 3);
        Page<JPABook> page = jpaBookService.getJPABookByPage(pageRequest);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("查询结果：" + page.getContent());
        System.out.println("当前页数：" + page.getNumber() + 1);
        System.out.println("当前页记录数：" + page.getNumberOfElements());
        System.out.println("每页记录数：" + page.getSize());
    }

    @GetMapping("/search")
    public void search(JPABook jpaBook) {
        System.out.println(jpaBookService.getMaxIdJPABook().toString());
        System.out.println(jpaBookService.getJPABooksByAuthorStartingWith(jpaBook.getAuthor()).toString());
//        System.out.println(jpaBookService.getJPABooksByIdAndName(jpaBook.getName(), jpaBook.getId()).toString());
        System.out.println(jpaBookService.getJPABooksByAuthorStartingWith(jpaBook.getAuthor()).toString());
        System.out.println(jpaBookService.getJPABooksByPriceGreaterThan(jpaBook.getPrice()).toString());
    }

    @GetMapping("/save")
    public void save(String name, String author, Float price) {
        JPABook jpaBook = new JPABook();
        jpaBook.setName(name);
        jpaBook.setAuthor(author);
        jpaBook.setPrice(price);
        jpaBookService.addJPABook(jpaBook);
    }
}
