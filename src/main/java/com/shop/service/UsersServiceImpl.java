package com.shop.service;

import com.shop.mapper.UsersMapper;
import com.shop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersMapper usersMapper;
	public Users LoginQuery(Users users) {
		
		return usersMapper.LoginQuery(users);
	}
	public void AddUsers(Users users) {
		usersMapper.AddUsers(users);
		
	}
	public List<Users> queryAll() {
		// TODO Auto-generated method stub
		return usersMapper.queryAll();
	}

}
