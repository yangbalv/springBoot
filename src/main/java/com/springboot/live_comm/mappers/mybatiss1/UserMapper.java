package com.springboot.live_comm.mappers.mybatiss1;

import com.springboot.live_comm.entity.security.Role;
import com.springboot.live_comm.entity.security.User;

import java.util.List;

public interface UserMapper {
    User loadUserByUsername(String username);

    User getUserByUsername(String username);

    List<Role> getUserRolesByUserId(Integer id);

    Integer addUser(User user);

}
