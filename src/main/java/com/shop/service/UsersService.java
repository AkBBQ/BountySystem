package com.shop.service;

import com.shop.model.Users;

import java.util.List;

public interface UsersService {
 Users LoginQuery(Users users);//login
 void  AddUsers(Users users);//添加Users
 public List<Users> queryAll();//后台查询所有用户信息
 Users queryOne(String name);//根据用户名查找用户
 void update(Users users);//修改用户信息
 Users queryOneuser(Integer id);
}
