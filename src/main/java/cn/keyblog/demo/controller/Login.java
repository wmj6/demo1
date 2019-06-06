package cn.keyblog.demo.controller;

import cn.keyblog.demo.dao.AllUser;
import cn.keyblog.demo.dao.getUser;
import com.alibaba.fastjson.JSON;
import cn.keyblog.demo.util.Json.Model.MyLogin;
import cn.keyblog.demo.util.Json.jsonCore.ListObject;
import cn.keyblog.demo.util.Json.status.StatusHouse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import cn.keyblog.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Login {

    @Resource
    private AllUser allUser;

    @RequestMapping("/login")
    public String log(){
        return "login";
    }

    @RequestMapping("/M-login")
    @ResponseBody
    public String login (HttpServletRequest request){
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        if(name==null||pwd==null)   return null;
        User myuser = allUser.select(name);
        List<MyLogin> myLogins = new ArrayList<>();
        if(myuser==null){
            return "no users found!";
        }else{
            if(pwd.equals(myuser.getPassword())){
                return myuser.getUsername();
            }else{
                return "wrong password!";
            }
        }
    }
}
