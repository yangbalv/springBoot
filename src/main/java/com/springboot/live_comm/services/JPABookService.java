package com.springboot.live_comm.services;

import com.springboot.live_comm.dao.JPABookDao;

import com.springboot.live_comm.entity.JPABook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPABookService {
    @Autowired
    JPABookDao jpaBookDao;

    public void addJPABook(JPABook jpaBook) {
        jpaBookDao.save(jpaBook);
    }

    public Page<JPABook> getJPABookByPage(Pageable pageable) {
        return jpaBookDao.findAll(pageable);
    }

    public List<JPABook> getJPABooksByAuthorStartingWith(String author) {
        return jpaBookDao.getJPABooksByAuthorStartingWith(author);
    }

    public List<JPABook> getJPABooksByPriceGreaterThan(Float price) {
        return jpaBookDao.getJPABooksByPriceGreaterThan(price);
    }

    public JPABook getMaxIdJPABook() {
        return jpaBookDao.getMaxIdJPABook();
    }

    public List<JPABook> getJPABooksByIdAndAuthor(String author, Integer id) {
        return jpaBookDao.getJPABooksByIdAndAuthor(author, id);
    }

//    public List<JPABook> getJPABooksByIdAndName(String name, Integer id) {
//        return jpaBookDao.getJPABooksByIdAndName(name, id);
//    }

    @Override
    public String toString() {
        return "JPABookService{" +
                "jpaBookDao=" + jpaBookDao +
                '}';
    }
}
