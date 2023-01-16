package com.springboot.live_comm.mappers.mybatiss1;

import com.springboot.live_comm.entity.security.Role;
import com.springboot.live_comm.entity.security.User;
import com.springboot.live_comm.entity.user.UserDetails;

import java.util.List;

public interface UserDetailsMapper {
    UserDetails getById(String id);

    Integer addUserDetails(UserDetails userDetails);
}
