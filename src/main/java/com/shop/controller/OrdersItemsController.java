package com.shop.controller;

import com.shop.model.OrderItems;
import com.shop.service.OrderItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("orderitems")
@Controller
public class OrdersItemsController {

	@Resource
	OrderItemsService orderItemsService;
	
	//添加订单详情表信息
	@RequestMapping("add")
	public void add(OrderItems orderItems){
		orderItemsService.add(orderItems);
	}
	
	//查看订单详情
	@RequestMapping("show")
	public String show(String id,Model model){
		List<OrderItems> list=orderItemsService.queryAllByOid(id);
		for(OrderItems oo:list){
			System.out.println("每一笔订单详情为"+oo);
		}
		model.addAttribute("list", list);
		return "OrderTails";
	}
	
	//查看订单详情 后台
	@RequestMapping("show2")
	public String show2(String id,Model model){
		List<OrderItems> list=orderItemsService.queryAllByOid(id);
		for(OrderItems oo:list){
			System.out.println("每一笔订单详情为"+oo);
		}
		model.addAttribute("list", list);
		return "orders/OrdersTails";
	}
}
