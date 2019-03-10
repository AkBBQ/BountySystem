package com.shop.mapper;

import com.shop.model.Users;

import java.util.List;

public interface UsersMapper {
	
	Users LoginQuery(Users users); //登陆
	
	public void AddUsers(Users users);//注册用户
    
	public List<Users> queryAll();//后台查询所有用户信息

	Users queryOne(String name); //根据用户名查找用户

	void update(Users users);//更新用户

	Users queryOneUser(Integer id);


}
