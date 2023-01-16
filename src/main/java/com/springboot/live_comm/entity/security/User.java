package com.springboot.live_comm.entity.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private String detailsId;
    private List<Role> roles;

    //    用户关系
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //    is帐户未过期
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    //    is帐户未锁定
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    //    is账户的密码未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账户是否可用
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }
    //    由于重写了isEnabled所以不能写set方法不然相当于出现了两个set方法
//    public String getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(String enabled) {
//        this.enabled = enabled;
//    }
//
//    public String getLocked() {
//        return locked;
//    }
//
//    public void setLocked(String locked) {
//        this.locked = locked;
//    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", detailsId='" + detailsId + '\'' +
                ", roles=" + roles +
                '}';
    }
}
