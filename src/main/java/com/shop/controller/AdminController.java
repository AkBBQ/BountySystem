package com.shop.controller;

import com.shop.model.Admin;
import com.shop.service.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("Admin")
public class AdminController {

	@Resource
	AdminServiceImpl adminServiceImpl;
	
	@ResponseBody
	@RequestMapping("login")
	public int Login(Admin admin){
		int flag=0;//成功
		Admin admin2=new Admin();
		admin2=adminServiceImpl.Login(admin);
		if (admin2==null) {
			flag=1;//用户名错误
		}else if (!admin2.getPassword().equals(admin.getPassword())) {
			flag=2;//密码错误
		} 
		return flag;
	}
}
