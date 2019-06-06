package cn.keyblog.demo.controller;

import cn.keyblog.demo.dao.AllUser;
import cn.keyblog.demo.util.Json.Model.MyLogin;
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

    /**
     * 转发登录页面
     * @return
     */
    @RequestMapping("/login")
    public String log(){
        return "login";
    }

    /**
     * 处理登录请求
     * @param request
     * @return
     */
    @RequestMapping("/M-login")
    @ResponseBody
    public String login (HttpServletRequest request){
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        if(name==null||pwd==null)   return null;
        User myuser = allUser.select(name);
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
