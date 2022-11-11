package com.springboot.live_comm.services;

//import com.springboot.live_comm.dao.BookDao;
import com.springboot.live_comm.entity.Book;
import com.springboot.live_comm.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
//    JdbcTemplate配置数据库

    //    @Autowired
//    BookDao bookDao;
//
//    public int addBook(Book book) {
//        return bookDao.addBook(book);
//    }
//
//    public int updateBook(Book book) {
//        return bookDao.updateBook(book);
//    }
//
//    public int deleteBookById(Integer id) {
//        return bookDao.deleteBookById(id);
//    }
//
//    public Book getBookById(Integer id) {
//        return bookDao.getBookById(id);
//    }
//
//    public List<Book> getAllBooks() {
//        return bookDao.getAllBooks();
//    }
    @Autowired
    BookMapper bookMapper;

    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    public int updateBook(Book book) {
        return bookMapper.updateBookById(book);
    }

    public int deleteBookById(Integer id) {
        return bookMapper.deleteBookById(id);
    }

    public Book getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }
}
