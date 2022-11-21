package com.springboot.live_comm.dao.jpaDao2;

import com.springboot.live_comm.entity.JPAUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//设置跨域访问（此类支持跨域访问，使用全局设置）
@CrossOrigin
@RepositoryRestResource(path = "zzzzz", collectionResourceRel = "bs" ,itemResourceRel = "b" ,exported = true)
public interface JpaUserDao2 extends JpaRepository<JPAUser, Integer> {
//    @CrossOrigin写在方法上则对方法进行单独的设置

}