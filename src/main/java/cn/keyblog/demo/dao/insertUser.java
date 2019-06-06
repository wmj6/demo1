package cn.keyblog.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class insertUser {

    private JdbcTemplate jdbcTemplate;
    public insertUser(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean register(String name,String pwd,String username){
        String sql = "insert user(id,name,password,username) values('"+UUID.randomUUID()+"','"+name+"','"+pwd+"','"+username+"')";
        System.out.println(sql);
        return jdbcTemplate.update(sql)>0;
    }
}
