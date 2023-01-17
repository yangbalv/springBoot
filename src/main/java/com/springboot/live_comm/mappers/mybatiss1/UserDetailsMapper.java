package com.springboot.live_comm.mappers.mybatiss1;

import com.springboot.live_comm.entity.user.UserDetails;

public interface UserDetailsMapper {
    UserDetails getById(String id);

    Integer addUserDetails(UserDetails userDetails);

    int update(UserDetails userDetails);
}
