package com.shop.model;

import lombok.Data;

import java.util.Date;

@Data
public class Mission {

    public int id;

    public int type;

    public  String content;

    public Date creatTime;

    public Date endTime;

    public String place;

    public int status;

    public  int lock;

    public int pid;

    public String title;

    public int pagesize=10;

    public int pageNo;

    public int offset;

}