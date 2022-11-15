package com.springboot.live_comm.controller.book;

import com.springboot.live_comm.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisBookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")
    public void test1() {
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name", "三国演义");
        String name = ops1.get("name");
        System.out.println(name);
        ValueOperations ops2 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        ops2.set("b1", book);
        Book book1 = (Book) ops2.get("b1");
        System.out.println(book1);
    }
}
