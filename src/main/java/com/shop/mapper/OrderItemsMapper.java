package com.shop.mapper;

import com.shop.model.OrderItems;

import java.util.List;

public interface OrderItemsMapper {
  
	public void add(OrderItems orderItems);//添加订单
  
	public List<OrderItems> queryAll(int id);//根据用户id查看订单详情和图书详情 
	
	public List<OrderItems> queryAllByOid(String orderid);//根据orderid查看订单详情和图书详情 
  
}