package com.shop.controller;

import com.shop.model.Cart;
import com.shop.model.Users;
import com.shop.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

	@Resource
	CartService cartService;
	
	/*Ajax实现添加*/
	@ResponseBody
	@RequestMapping("add")
	public void add(Cart cart){
		/*System.out.println("前台传过来的用户id为"+cart.getUserId());
		System.out.println("前台传过来的书籍id为"+cart.getBookId()); //当添加同样的书籍的时候 只会update书籍的数量
		System.out.println("前台传过来的书籍数量为为"+cart.getNum());*/
		int Num=cart.getNum();//添加的数量
		int BookId=cart.getBookId();//获取到将要添加进来的bookid
		Cart iscarton=cartService.queryBookId(BookId);//根据bookid查询这条记录是否存在 
		System.out.println("查询到此bookID的购物车记录为"+iscarton);
		if (iscarton!=null) {  //如果存在的话 则进行update操作
			Cart newCart=new Cart();
			newCart.setNum(iscarton.getNum()+Num);
			newCart.setBookId(BookId);
			cartService.update(newCart);
		}else {
			//否则则新增操作
			cartService.add(cart);
			
		}
		
		
	}
	
	/*展示购物车信息*/
	@RequestMapping("showCart")
	public String showCart(Model model,HttpSession session){
		Users users=(Users) session.getAttribute("userinfo");
		System.out.println("session中的id为_________________________________________________"+users.getId());
		
		
		double nowPrice = 0; //总价(原价)
	
		int Numbs=0;//总件数
		/*List<Cart> carts=cartService.queryAll();*/
		List<Cart> carts=cartService.queryOneAll(users.getId());
		for(Cart cc:carts){
			double total = (double) (cc.getNum()*cc.getBook().getPrice());
			int num=cc.getNum();
			nowPrice+=total;
			Numbs+=num;
		}
		System.out.println("现价"+nowPrice+"总商品数为"+Numbs);
		List<Object> arr=new ArrayList<Object>();// 填入 通用类型 Object
		arr.add(nowPrice); //get(0) //总价格
		arr.add(Numbs);//get(1) 总数
		model.addAttribute("info", arr);
		session.setAttribute("cartInfo", arr);//购物车信息放入到session中
		/*model.addAttribute("list",cartService.queryAll());*/
		model.addAttribute("list",cartService.queryOneAll(users.getId()));
		return "checkout";
	}
	
	
	/*删除指定ID的购物车信息*/
	@RequestMapping("del")
public String del(int id){
		cartService.del(id);
		return "redirect:../cart/showCart";
		
	}
	
	/*清空购物车*/
	@RequestMapping("delAll")
	public String delAll(){
		
		cartService.delAll();
		
		return "redirect:../cart/showCart";
	}
	
}
