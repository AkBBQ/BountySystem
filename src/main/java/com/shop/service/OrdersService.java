package com.shop.service;

import com.shop.model.Orders;

import java.util.List;

public interface OrdersService {
  
	public void add(Orders orders);//添加订单
	
	public List<Orders> queryAll();//查询订单表(包含了每个订单的订单详情)
	
	public List<Orders> queryAllById(Integer id);//根据用户id查询他账号下的订单
	
	public void SendGood(Orders orders);//发货 将订单状态修改为1,增加发货日期
  
}