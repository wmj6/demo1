package cn.keyblog.demo.dao;

import cn.keyblog.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AllUser {

    /**
     * 获取字段name为name的数据
     * @param name
     * @return
     */
    @Select("select id,name,password,username from user where name=#{name}")
    public User select(@Param("name") String name);

    /**
     * 获取user表全部数据
     * @return
     */
    @Select("select id,name,password,username from user")
    public List<User> All();

    /**
     * 向user表插入数据
     * @param id
     * @param name
     * @param password
     * @param username
     */
    @Insert("insert user(id,name,password,username) values(#{id},#{name},#{password},#{username})")
    public void insert(@Param("id")String id,@Param("name") String name,@Param("password")String password,@Param("username")String username);
}
