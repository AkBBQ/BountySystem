package com.shop.service;

import com.shop.model.SmallClass;

import java.util.List;

public interface SmallClassService {

	List<SmallClass> queryAll();
	void add(SmallClass smallClass);//增加一个大类
	List<SmallClass> querySmallname(String name);//根据大类的id查询对应小类的名字
	void del(int id);//删除大类
	void update(SmallClass smallClass);//编辑大类
	SmallClass queryById(int id);//编辑大类的时候根据id来传值
	
}
