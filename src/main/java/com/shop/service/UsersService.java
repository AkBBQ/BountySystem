package com.shop.service;

import com.shop.model.Users;

import java.util.List;

public interface UsersService {
 Users LoginQuery(Users users);//login
 void  AddUsers(Users users);//添加Users
 public List<Users> queryAll();//后台查询所有用户信息
}
