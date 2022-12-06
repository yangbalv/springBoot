package com.springboot.live_comm.dao;

import com.springboot.live_comm.configs.cacheConfig.MyKeyGenerator;
import com.springboot.live_comm.entity.CacheBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "book_cache")
public class CacheBookDao {
    @Autowired
    MyKeyGenerator myKeyGenerator;

//    缓存在使用时需要主要缓存所设置的key，默认情况下使用请求参数作为key，若数据是基本数据类型则可以不依赖缓存规则，
//    请求参数为实体类，则请求时使用实体类的实际地址作为缓存的key，两个内容相同的实体类就不会匹配到相同的缓存，
//    此时就需要定义缓存key的生成规则

    //    设置支持缓存（即访问时会添加缓存）
//    @Cacheable(keyGenerator = "myKeyGenerator")
    @Cacheable()
    public CacheBook getBookById(Integer id) {
        System.out.println("getBookById");
        CacheBook book = new CacheBook();
        book.setId(id);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        return book;
    }

    //    修改缓存
    //    condition表示判定条件生效才执行
    @CachePut(key = "#book.id", condition = "#book.name!=\"我的\"")
//    @CachePut(keyGenerator = "myKeyGenerator")
    public CacheBook updateBookById(CacheBook book) {
        System.out.println("updateBookById");
        return book;
    }

    //    删除缓存
    @CacheEvict(key = "#id")
//    @CacheEvict(keyGenerator = "myKeyGenerator")
    public void deleteBookById(Integer id) {
        System.out.println("deleteBookById");
    }


    @Cacheable()
    public CacheBook addBook(CacheBook book) {
        System.out.println("addBook");
        return book;
    }


    @CachePut()
    public CacheBook updateBook(CacheBook book) {
        System.out.println("updateBook");
        return book;
    }

    @CacheEvict()
    public CacheBook deleteBook(CacheBook book) {
        System.out.println("deleteBook");
        return book;
    }

    @Cacheable(keyGenerator = "myKeyGenerator")
    public CacheBook addBook2(CacheBook book) {
        System.out.println("addBook2");
        return book;
    }

    @CachePut(keyGenerator = "myKeyGenerator")
    public CacheBook updateBook2(CacheBook book) {
        System.out.println("updateBook2");
        return book;
    }

    @CacheEvict(keyGenerator = "myKeyGenerator")
    public CacheBook deleteBook2(CacheBook book) {
        System.out.println("deleteBook2");
        return book;
    }
}
