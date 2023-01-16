package com.springboot.live_comm.services.user;

import com.springboot.live_comm.entity.user.UserDetails;
import com.springboot.live_comm.mappers.mybatiss1.UserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    @Autowired
    UserDetailsMapper userDetailsMapper;

    public UserDetails getById(String id) {
        return userDetailsMapper.getById(id);
    }

    public Integer addUserDetails(UserDetails userDetails) {
        return userDetailsMapper.addUserDetails(userDetails);
    }

}
