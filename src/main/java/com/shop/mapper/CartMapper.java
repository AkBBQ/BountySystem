package com.shop.mapper;

import com.shop.model.Cart;

import java.util.List;

public interface CartMapper {
	
	public List<Cart> queryAll();//查询全部 注入了book表中的信息
	
	public List<Cart> queryOneAll(Integer id);//根据user_id查询某个用户的全部 订单信息
	
	public void add(Cart cart);//添加购物车信息 
	
	public void del(int id);//删除一条购物车信息
	
	public void delAll();//清空购物车
	
	public Cart queryBookId(int id);//查询插入进来的书是否已经存在
	
	public void update(Cart cart);//当新增的时候出现相同的书的时候只要update书的数量即可
	
	

}
