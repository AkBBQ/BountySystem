package com.shop.model;

import lombok.Data;

import java.util.Date;

@Data
public class Users {
    //用户id
    public Integer id;
    //用户名
    public String name;
    //用户密码
    public String pwd;
    //手机号
    public String phone;
    //注册时间
    public Date creatTime;

}