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
import org.springframework.transaction.annotation.Transactional;

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

    public User getUserByUserName(String username) {
        User user = userMapper.loadUserByUsername(username);
        if (user != null) {
            user.setRoles(userMapper.getUserRolesByUserId(user.getId()));
        }
        return user;
    }


    //
//    项目中同时出现多个数据源和相关的事务管理器时，在使用@Transactional()注解时如果不直接指定使用的数据源，Spring就不知道具体使用哪一个事务管理器来进行事务管理了，因此需要通过某种方式来具体指定一下。可以通过使用 @Transactional(transactionManager = “xxTransactionManager”) 来进行指定。
//    配置的事务管理器对象忘记加@Bean注解，加上就扫描出来了。
//            ————————————————
//    版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/web13985085406/article/details/126607568
    @Transactional(transactionManager = "platformTransactionManagerOne")
    public void lockUser(User user) {
        userMapper.lockUser(user);
    }

    @Transactional(transactionManager = "platformTransactionManagerOne")
    public void unlockUser(User user) {
        userMapper.unlockUser(user);
    }

}
