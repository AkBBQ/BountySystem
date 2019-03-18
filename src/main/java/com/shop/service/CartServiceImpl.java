package com.shop.service;

import com.shop.mapper.CartMapper;
import com.shop.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
    CartMapper cartMapper;

	public void add(Cart cart) {
		// TODO Auto-generated method stub
		cartMapper.add(cart);
		
	}

	public void del(int id) {
		// TODO Auto-generated method stub
		cartMapper.del(id);
		
	}

	public List<Cart> queryAll() {
		// TODO Auto-generated method stub
		return cartMapper.queryAll();
	}

	public void update(Cart cart) {
		// TODO Auto-generated method stub
		cartMapper.update(cart);
		
	}

	public Cart queryBookId(int id) {
		// TODO Auto-generated method stub
		return cartMapper.queryBookId(id);
	}

	public void delAll() {
		// TODO Auto-generated method stub
		cartMapper.delAll();
		
	}

	public List<Cart> queryOneAll(Integer id) {
		// TODO Auto-generated method stub
		return cartMapper.queryOneAll(id);
	}

	


	

	

	

}
