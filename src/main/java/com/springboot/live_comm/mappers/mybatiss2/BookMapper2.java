package com.springboot.live_comm.mappers.mybatiss2;

import com.springboot.live_comm.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface BookMapper2 {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBookById(Book book);

    Book getBookById(Integer id);

    List<Book> getAllBooks();

}
