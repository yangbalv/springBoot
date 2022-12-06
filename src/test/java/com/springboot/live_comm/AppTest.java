package com.springboot.live_comm;

import com.springboot.live_comm.dao.CacheBookDao;
import com.springboot.live_comm.entity.CacheBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    CacheBookDao bookDao;

    @Test
    public void contextLoads() {
        bookDao.deleteBookById(1);
        bookDao.getBookById(1);
        bookDao.getBookById(1);
        bookDao.deleteBookById(1);
        CacheBook b3 = bookDao.getBookById(1);
        System.out.println("b3: " + b3);
        CacheBook b = new CacheBook();
        b.setName("b");
        b.setAuthor("b");
        b.setId(1);
        bookDao.updateBookById(b);
        CacheBook b4 = bookDao.getBookById(1);
        System.out.println("b4: " + b4);
        bookDao.deleteBookById(1);

        bookDao.deleteBookById(2);
        bookDao.getBookById(2);
        CacheBook b2 = new CacheBook();
        b2.setName("b2");
        b2.setAuthor("b2");
        b2.setId(2);
        bookDao.updateBookById(b2);
        CacheBook b5 = bookDao.getBookById(2);
        System.out.println(b5);
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(1);
        bookDao.deleteBookById(2);
    }

    @Test
    public void getBookById() {
        System.out.println(bookDao.getBookById(1));
        System.out.println(bookDao.getBookById(2));
    }

    @Test
    public void updateBookById() {
        CacheBook b = new CacheBook();
        b.setName("测试1");
        b.setAuthor("测试1");
        b.setId(1);
        bookDao.updateBookById(b);

        CacheBook b2 = new CacheBook();
        b2.setName("测试2");
        b2.setAuthor("测试2");
        b2.setId(2);
        bookDao.updateBookById(b2);

    }


    @Test
    public void add() {
        CacheBook book = new CacheBook();
        book.setName("测试1");
        book.setAuthor("测试1");
        book.setId(1);
        System.out.println(bookDao.addBook(book));
        System.out.println(bookDao.addBook(book));
//        缓存一次（按照指针进行缓存而不是对象的属性）
    }


    @Test
    public void add2() {
        CacheBook book = new CacheBook();
        book.setName("测试2");
        book.setAuthor("测试2");
        book.setId(2);

        CacheBook book2 = new CacheBook();
        book2.setName("测试2");
        book2.setAuthor("测试2");
        book2.setId(2);
        System.out.println(bookDao.addBook(book));
        System.out.println(bookDao.addBook(book2));
//        缓存了两次（两个都是新建的对象所以会按照对象的指针进行两次缓存的添加）
    }


    @Test
    public void deleteBook() {
        CacheBook book = new CacheBook();
        book.setName("测试1");
        book.setAuthor("测试1");
        book.setId(1);
        System.out.println(bookDao.deleteBook(book));
//        不可以删除（看起来是删除了，但是实际上并没有删除）
    }


    @Test
    public void updateBook() {

        CacheBook book = new CacheBook();
        book.setName("测试1");
        book.setAuthor("测试1");
        book.setId(1);
        System.out.println(bookDao.addBook(book));
        book.setId(2);
        System.out.println(bookDao.updateBook(book));
        System.out.println(bookDao.addBook(book));
//
    }

    @Test
    public void add21() {
        CacheBook book = new CacheBook();
        book.setName("测试1");
        book.setAuthor("测试1");
        book.setId(1);
        System.out.println(bookDao.addBook2(book));
        System.out.println(bookDao.addBook2(book));
//        缓存一次（按照缓存策略进行的缓存）
    }


    @Test
    public void add22() {
        CacheBook book = new CacheBook();
        book.setName("测试2");
        book.setAuthor("测试2");
        book.setId(2);

        CacheBook book2 = new CacheBook();
        book2.setName("测试2");
        book2.setAuthor("测试2");
        book2.setId(2);
        System.out.println(bookDao.addBook2(book));
        System.out.println(bookDao.addBook2(book2));
//        缓存了一次
    }

    @Test
    public void deleteBook2() {
        CacheBook book = new CacheBook();
        book.setName("测试1");
        book.setAuthor("测试1");
        book.setId(1);
        System.out.println(bookDao.deleteBook2(book));
//        可以删除（看起来是删除了，但是实际上也删除了）
    }
    @Test
    public void deleteBook22() {
        CacheBook book = new CacheBook();
        book.setName("测试2");
        book.setAuthor("测试2");
        book.setId(2);
        System.out.println(bookDao.deleteBook2(book));
    }
}