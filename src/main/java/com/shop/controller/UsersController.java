package com.shop.controller;

import com.shop.model.Users;
import com.shop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("Login")
@Controller
public class UsersController {

    @Autowired
    UsersService usersService;

    /**
     * 登录操作
     */
    @ResponseBody
    @RequestMapping(value = "login")
    public int Login(Users users, HttpSession session) {
        //登录成功是否标准,0成功
        int flag = 0;
        Users users2 = new Users();
        users2 = usersService.LoginQuery(users);
        if (users2 == null) {
            //无该用户  flag设置为1
            flag = 1;
        } else if (!users2.getPwd().equals(users.getPwd())) {
            //密码错误 flag设置为2
            flag = 2;
        } else {
            //把登陆成功的用户信息放在session中，session有效期为一天
            session.setAttribute("userinfo", users2);
            session.setMaxInactiveInterval(60 * 60 * 60 * 24);
        }
            return flag;
    }

    /**
     * 注册操作
     */
    @ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Integer Register(Users users) {
        //0成功 添加异常1 有空字段2
        Integer flag=0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date date = new Date();
        simpleDateFormat.format(date);
        users.setCreatTime(date);
        if(!StringUtils.isEmpty(users.getName()) && !StringUtils.isEmpty(users.getPwd()) &&!StringUtils.isEmpty(users.getPhone())){
        try {
            usersService.AddUsers(users);
        } catch (Exception e) {
            flag=1;
            e.printStackTrace();
        }

        }else{
            flag=2;
        }
        return flag;



    }
/**
 *直接拿到session中的当前登陆者
 */
    @RequestMapping("/getUserFromSession")
    public String getUserInfo(HttpSession httpSession, Model model){
        Object userinfo = httpSession.getAttribute("userinfo");
        model.addAttribute("user",userinfo);
        return "myinfo.jsp";
    }

    /**
     *直接拿到session中的当前登陆者
     */
@RequestMapping("/session")
public String getUser(HttpSession httpSession,Model model){
    Object userinfo = httpSession.getAttribute("userinfo");
    model.addAttribute("user",userinfo);
    return "myinfo_update.jsp";
}

/**
 * 修改账号信息
 */

@ResponseBody
@RequestMapping("/update")
public Boolean  update(HttpSession session,Users users){
    try {
        usersService.update(users);
        //修改密码之后清空之前的session
        session.removeAttribute("userinfo");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return true;
}

}
