package com.shop.controller;

import com.shop.model.Users;
import com.shop.service.UsersServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("Login")
public class UsersController {

	@Resource
    UsersServiceImpl usersServiceImpl;
	
	/*登陆操作*/
	@ResponseBody
	@RequestMapping("login")
	public int Login(Users users, HttpSession session){
/*		System.out.println("用户名"+users.getUsername());
		System.out.println("密码"+users.getPassword());*/
		int flag=0;//
		Users users2=new Users();
		users2=usersServiceImpl.LoginQuery(users);
	
		if(users2==null){
			flag=1;//用户名错误  flag设置为1
		}else if (!users2.getPassword().equals(users.getPassword())) {
			flag=2;//密码错误 flag设置为2
		}
		session.setAttribute("userinfo", users2);//把登陆成功的用户信息放在session中
		session.setMaxInactiveInterval(60*60*60*24);//session有效期为一天
		return flag;	
		
		
		
	}
	
	/*注册操作*/
	@ResponseBody
	@RequestMapping("register")
	public void Register(Users users){
/*		System.out.println("前台传过来的username:"+users.getUsername());
		System.out.println("前台传过来的password:"+users.getPassword());
		System.out.println("前台传过来的phone"+users.getPhone());
		System.out.println("前台传过来的address"+users.getAddress());*/
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date=new Date();
		simpleDateFormat.format(date);
		users.setAddDate(date);
		usersServiceImpl.AddUsers(users);
		
	}
	
	
	/*注销当前账号*/
	@RequestMapping("quitLogin")
	public String quitLogin(HttpSession session){
    session.removeAttribute("userinfo");//注销登陆	
    session.removeAttribute("cartInfo");//注销购物车中的session
    return "redirect:/index";
	}
	
	@RequestMapping("show")
	public String queryAll(Model model){
		model.addAttribute("list",usersServiceImpl.queryAll());
		return "users/users_list";
	}
	
}
