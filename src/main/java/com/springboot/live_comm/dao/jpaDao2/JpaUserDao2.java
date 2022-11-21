package com.springboot.live_comm.dao.jpaDao2;

import com.springboot.live_comm.entity.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "zzzzz", collectionResourceRel = "bs" ,itemResourceRel = "b" ,exported = false)
public interface JpaUserDao2 extends JpaRepository<JPAUser, Integer> {

}