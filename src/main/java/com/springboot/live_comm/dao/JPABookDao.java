package com.springboot.live_comm.dao;

import com.springboot.live_comm.entity.JPABook;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Spring Data JPA中只要方法的定义符合既定规范，Spring Data 就可以分析出开发者的意图，完成特定的SQL进而完成Sql的设计
public interface JPABookDao extends JpaRepository<JPABook, Integer> {
    List<JPABook> getJPABooksByAuthorStartingWith(String author);

    List<JPABook> getJPABooksByPriceGreaterThan(Float price);

    @Query(value = "select * from t_book where id=(select max(id) from t_book )", nativeQuery = true)
    JPABook getMaxIdJPABook();

    @Query("select b from t_book b where b.id >:id  and b.author=:author ")
    List<JPABook> getJPABooksByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);

//    @Query( "select b from t_book b where b.id <? 2 and b.name like %?1%")
//    List<JPABook> getJPABooksByIdAndName(String name, Integer id);
}
