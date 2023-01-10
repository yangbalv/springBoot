package com.springboot.live_comm.services.security;

import com.springboot.live_comm.configs.security.MultiHttpSecurityConfig;
import com.springboot.live_comm.entity.security.User;
import com.springboot.live_comm.mappers.mybatiss1.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println(username);
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在");
        }
        user.setRoles(userMapper.getUserRolesByUserId(user.getId()));
        return user;
    }

    public Integer addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(MultiHttpSecurityConfig.BCrypt_Password_Encoder_TIMES);
        String password = user.getPassword();
        password = encoder.encode(password);
        System.out.println(password);
        user.setPassword(password);
        return userMapper.addUser(user);
    }
}
