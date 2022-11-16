package com.springboot.live_comm.controller.jpa;

import com.springboot.live_comm.dao.jpaDao1.JpaUserDao;
import com.springboot.live_comm.dao.jpaDao2.JpaUserDao2;
import com.springboot.live_comm.entity.JPAUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vJpa")
public class VersatileJpaController {
    @Autowired
    JpaUserDao jpaUserDao1;
    @Autowired
    JpaUserDao2 jpaUserDao2;

    @GetMapping("/test1")
    public void test1() {
        JPAUser user = new JPAUser();
        user.setAge(55);
        user.setName("胡夏");
        user.setGender("男");
        jpaUserDao1.save(user);
        JPAUser user2 = new JPAUser();
        user2.setAge(23);
        user2.setName("赵军");
        user2.setGender("女");
        jpaUserDao2.save(user2);

    }
}
