package com.springboot.live_comm.services.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
//基于方法的权限设置（PreAuthorize，PostAuthorize都可以使用基于表达式的语法）
public class MethodService {
    //    这里的角色前面需要加一个ROLE_前缀
    @Secured("ROLE_ADMIN")
    public String admin() {
        return "hello admin!";
    }

    //    方法使用前验证
    @PreAuthorize("hasRole('ADMIN') and hasRole('DBA')")
    public String dba() {
        System.out.println("方法执行中");
        return "hello dba!";
    }

    //方法使用后验证
    @PostAuthorize("hasAnyRole('Admin','DBA','USER')")
    public String user() {
        System.out.println("方法执行中");
        return "hello admin!";
    }
}
