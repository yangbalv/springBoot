package com.springboot.live_comm.mappers;

import com.springboot.live_comm.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface BookMapper {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBookById(Book book);

    Book getBookById(Integer id);

    List<Book> getAllBooks();

}
