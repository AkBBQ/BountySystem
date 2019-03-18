package com.shop.controller;

import com.shop.model.Cart;
import com.shop.model.OrderItems;
import com.shop.model.Orders;
import com.shop.service.CartService;
import com.shop.service.OrderItemsService;
import com.shop.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {

	@Resource
	OrdersService ordersService;
	
	@Resource
	CartService cartService;
	
	@Resource
	OrderItemsService orderItemsService;
	
	@ResponseBody
	@RequestMapping("add")
	public String add(Orders orders, Model model){
		System.out.println("前台传来的用户id"+orders.getUserId());
		System.out.println("前台传来的用户名"+orders.getUsername());
		System.out.println("前台传来的手机号"+orders.getPhone());
		System.out.println("前台传来的地址为"+orders.getAddress());
		System.out.println("前台传来的日期为:"+orders.getOrderDate());
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date=new Date();
		simpleDateFormat.format(date);
		//点击下单将当时时间记录到数据库中
		orders.setOrderDate(date);
		
		//生成随机订单号
		String orderIDString="";
		for (int i=0; i <8; i++) {
			int j=(int) Math.floor(Math.random()*10);
			orderIDString+=j;
		}
		System.out.println("订单号"+orderIDString);
		orders.setOrderId(orderIDString);
		ordersService.add(orders); //将订单信息存放到订单详表中
		
		//操作订单详情表
		List<Cart> list=cartService.queryOneAll(orders.getUserId());//首先先查出当前下单用户的用户id对应的购物车信息
		for(Cart cc:list){
			System.out.println("当前用户"+orders.getUsername()+"的购物车详情为"+cc);
			OrderItems orderItems=new OrderItems();
			orderItems.setOrderId(orderIDString); //添加orderId
			orderItems.setBookId(cc.getBookId());//添加bookid
			orderItems.setPrice(cc.getBook().getPrice());//添加价格
			orderItems.setNum(cc.getNum()); //添加数量
			orderItemsService.add(orderItems); //加入进去
			
		}
		
		//查看订单详情
		List<OrderItems> orderItems=orderItemsService.queryAll(orders.getUserId());
		for(OrderItems o:orderItems){
			System.out.println("该用户的订单表为:"+o);
		}
		model.addAttribute("list",orderItemsService.queryAll(orders.getUserId()));
		
		return "myOrders";
		
	}
	
	@RequestMapping("showOrders")
	public String showOrders(Model model,int id){
		
		model.addAttribute("list",ordersService.queryAllById(id));
		return "myOrders";
	}
	
	//后台查询所有订单信息
	@RequestMapping("showAll")
	public String showAll(Model model){
		model.addAttribute("list", ordersService.queryAll());
		return "orders/Orders";
	}
	
	//后台发货处理
	@ResponseBody
	@RequestMapping("sendGoods")
	public void SendGoods(Orders orders){
		System.out.println("Ajax传来的订单id为"+orders.getUserId());
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
		Date date=new Date();
		sdf.format(date); //当前时间为发货时间
		orders.setShipDate(date);
		ordersService.SendGood(orders);
		
	}
	
}
