package cn.keyblog.demo.dao;

import cn.keyblog.demo.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class getUser {

    private JdbcTemplate jdbcTemplate;
    public getUser(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public User User(String name){

        String sql = "select id,name,password,username from user where name='"+name+"'";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            User user = null;
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                return user;
            }
        });
        if(list.size()==0)
            return null;
        else
            return list.get(0);
    }
}
