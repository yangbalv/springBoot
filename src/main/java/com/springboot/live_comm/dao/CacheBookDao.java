//package com.springboot.live_comm.dao;
//
//import com.springboot.live_comm.configs.cacheConfig.MyKeyGenerator;
//import com.springboot.live_comm.entity.CacheBook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@CacheConfig(cacheNames = "book_cache")
//public class CacheBookDao {
//    @Autowired
//    MyKeyGenerator myKeyGenerator;
//
//    //    设置支持缓存，并设置缓存的名称
//    @Cacheable(keyGenerator = "myKeyGenerator",cacheNames = {"aa", "bb"})
//    public CacheBook getBookById(Integer id) {
//        System.out.println("getBookById");
//        CacheBook book = new CacheBook();
//        book.setId(id);
//        book.setName("三国演义");
//        book.setAuthor("罗贯中");
//        return book;
//    }
//
//    //    condition表示判定条件生效才执行
//    @CachePut(key = "#book.id", condition = "#book.name!=\"我的\"")
//    public CacheBook updateBookById(CacheBook book) {
//        System.out.println("updateBookById");
//        book.setName("三国演义2");
//        return book;
//    }
//
//    @CacheEvict(key = "#id")
//    public void deleteBookById(Integer id) {
//        System.out.println("deleteBookById");
//    }
//}
