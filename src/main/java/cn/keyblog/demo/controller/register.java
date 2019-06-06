package cn.keyblog.demo.controller;

import cn.keyblog.demo.dao.AllUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class register {

    @Resource
    private AllUser allUser;

    /**
     * 转发注册页面
     * @return
     */
    @RequestMapping("/register")
    public String reg(){
        return "register";
    }

    /**
     * 处理注册请求
     * @param request
     * @return
     */
    @RequestMapping("/M-register")
    @ResponseBody
    public String register(HttpServletRequest request){
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");
        String username = request.getParameter("username");
        if(name==null||pwd==null||username==null) {return "error!";}
        if(name.equals("")||pwd.equals("")||username.equals(""))   {return "error!";}

        if(allUser.select(name)==null){
            allUser.insert(String.valueOf(UUID.randomUUID()),name,pwd,username);
            return "success!";
        }else{
            return "account already exists!";
        }
    }
}
