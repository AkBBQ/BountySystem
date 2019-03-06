package com.shop.mapper;

import com.shop.model.Users;

import java.util.List;

public interface UsersMapper {
	
	Users LoginQuery(Users users); //登陆
	
	public void AddUsers(Users users);//注册用户
    
	public List<Users> queryAll();//后台查询所有用户信息
}
