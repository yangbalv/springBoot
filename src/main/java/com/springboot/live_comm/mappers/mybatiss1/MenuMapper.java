package com.springboot.live_comm.mappers.mybatiss1;

import com.springboot.live_comm.entity.security.Menu;

import java.util.List;

//@Mapper
public interface MenuMapper {
    List<Menu> getAllMenus();
}
