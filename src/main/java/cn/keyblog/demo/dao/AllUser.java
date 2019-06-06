package cn.keyblog.demo.dao;

import cn.keyblog.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AllUser {

    @Select("select id,name,password,username from user where name=#{name}")
    public User select(@Param("name") String name);

    @Select("select id,name,password,username from user")
    public List<User> All();
}
