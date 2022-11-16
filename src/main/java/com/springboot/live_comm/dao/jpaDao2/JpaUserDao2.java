package com.springboot.live_comm.dao.jpaDao2;

import com.springboot.live_comm.entity.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserDao2 extends JpaRepository<JPAUser, Integer> {

}