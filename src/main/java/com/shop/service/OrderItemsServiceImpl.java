package com.shop.service;

import com.shop.mapper.OrderItemsMapper;
import com.shop.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

	@Autowired
    OrderItemsMapper orderItemsMapper;
	
	public void add(OrderItems orderItems) {
		// TODO Auto-generated method stub
		orderItemsMapper.add(orderItems);
		
	}

	public List<OrderItems> queryAll(int id) {
		// TODO Auto-generated method stub
		return orderItemsMapper.queryAll(id);
	}

	public List<OrderItems> queryAllByOid(String orderid) {
		// TODO Auto-generated method stub
		return orderItemsMapper.queryAllByOid(orderid);
	}

	


}
