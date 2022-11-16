package com.springboot.live_comm.dao.jpaDao1;

import com.springboot.live_comm.entity.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserDao extends JpaRepository<JPAUser, Integer> {

}
