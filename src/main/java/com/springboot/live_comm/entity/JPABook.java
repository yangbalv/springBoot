//package com.springboot.live_comm.entity;
//
//import javax.persistence.*;
//
//@Entity(name = "t_book")
//public class JPABook {
//    @Id
////    主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    主键自动生成
//    private Integer id;
//
//    @Column(name = "book_name", nullable = false)
////    @Column可以自定义字段的属性
//    private String name;
//
//    private String author;
//    private Float price;
//    @Transient
////    表示数据被忽略
//    private String description;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public Float getPrice() {
//        return price;
//    }
//
//    public void setPrice(Float price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
