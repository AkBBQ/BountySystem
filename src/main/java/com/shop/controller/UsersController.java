package com.shop.controller;

import com.shop.model.Users;
import com.shop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("register")
    public void Register(Users users) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date date = new Date();
        simpleDateFormat.format(date);
        users.setCreatTime(date);
        usersService.AddUsers(users);

    }


}
