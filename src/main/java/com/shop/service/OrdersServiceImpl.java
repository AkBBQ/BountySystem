package com.shop.service;

import com.shop.mapper.OrdersMapper;
import com.shop.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrdersMapper ordersMapper;
	
	public void add(Orders orders) {
		// TODO Auto-generated method stub
		ordersMapper.add(orders);
		
	}

	public List<Orders> queryAll() {
		// TODO Auto-generated method stub
		return ordersMapper.queryAll();
	}

	public List<Orders> queryAllById(Integer id) {
		// TODO Auto-generated method stub
		return ordersMapper.queryAllById(id);
	}

	public void SendGood(Orders orders) {
		// TODO Auto-generated method stub
		ordersMapper.SendGood(orders);
		
	}




}
