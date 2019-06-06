package cn.keyblog.demo.controller;

import cn.keyblog.demo.dao.AllUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import cn.keyblog.demo.entity.User;


@Controller
public class Login {

    @Resource
    private AllUser allUser;

    /**
     * 转发登录页面
     * @return 返回login.jsp为登录页面
     */
    @RequestMapping("/login")
    public String log(){
        return "login";
    }

    /**
     * 处理登录请求
     * @param request 参数
     * @return 返回处理信息
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
