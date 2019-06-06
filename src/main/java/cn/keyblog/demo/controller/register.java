package cn.keyblog.demo.controller;

import cn.keyblog.demo.dao.getUser;
import cn.keyblog.demo.dao.insertUser;
import cn.keyblog.demo.util.Json.Model.MyLogin;
import com.alibaba.fastjson.JSON;
import cn.keyblog.demo.util.Json.jsonCore.ListObject;
import cn.keyblog.demo.util.Json.status.StatusHouse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class register {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/register")
    public String reg(){
        return "register";
    }

    @RequestMapping("/M-register")
    @ResponseBody
    public String register(HttpServletRequest request){
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        String username = request.getParameter("username");

        List<MyLogin> myLogins = new ArrayList<>();

        int flag=1;
        if(name==null||pwd==null||username==null) { myLogins.add(new MyLogin("404","no empty!"));flag=0;}
        if(flag==1&&name.equals("")||pwd.equals("")||username.equals(""))   {myLogins.add(new MyLogin("404","no empty!"));flag=0;}
        insertUser User = new insertUser(jdbcTemplate);
        getUser checkuser = new getUser(jdbcTemplate);
        cn.keyblog.demo.entity.User myuser = checkuser.User(name);
        if(flag==1){
            if(myuser==null){
                if(User.register(name,pwd,username))
                    myLogins.add(new MyLogin("200","register success!"));
                else
                    myLogins.add(new MyLogin("404","register fail!"));
            }else{
                myLogins.add(new MyLogin("404","account already exists!"));
            }
        }
        ListObject object = new ListObject();
        object.setItems(myLogins);
        object.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        return JSON.toJSONString(object);
    }
}
