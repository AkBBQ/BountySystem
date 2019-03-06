package com.shop.controller;

import com.shop.model.LargeClass;
import com.shop.model.SmallClass;
import com.shop.service.BookServiceImpl;
import com.shop.service.LargeClassServiceImpl;
import com.shop.service.SmallClassServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("class")
public class ClassController {

	@Resource
	LargeClassServiceImpl largeClassServiceImpl;
	
	@Resource
    SmallClassServiceImpl smallClassServiceImpl;
	
	@Resource
    BookServiceImpl bookServiceImpl;
	
	@RequestMapping("Lshow")
	public String show(Model model){
		List<LargeClass> list=largeClassServiceImpl.queryAll();
		/*for(LargeClass largeClass:list){
			System.out.println(largeClass);
		}*/
		model.addAttribute("list", list);
		return "book/large_class";
	}
	
	@RequestMapping("Ldel")
	public String Ldel(Model model,int id){
		largeClassServiceImpl.del(id);
		return "redirect:/class/Lshow";
	}
	
	@RequestMapping("LPreadd")
	public String Preadd(){
	
		return "book/large_add";
	}
	
	@RequestMapping("Ladd")
	public String Ladd(LargeClass largeClass){
	     largeClassServiceImpl.add(largeClass);
	     return "redirect:/class/Lshow";
	}
	
	@RequestMapping("Lpreupdate")
	public String Lpreupdate(Model model,int id){
	     model.addAttribute("list", largeClassServiceImpl.queryById(id));
	     return "book/large_update";
	}
	
	@RequestMapping("Lupdata")
	public String Lpreupdate(Model model, LargeClass largeClass){
	String lnameString=	largeClass.getName();//获取到修改的大类名字 传给book中的update方法 同时修改
	/*Book book=new Book();
	book.setSuperType(lnameString);
	System.out.println("book的信息是"+book);*/
	  /*  bookServiceImpl.updataLargeName(book);*/
	   largeClassServiceImpl.update(largeClass);
	   return "redirect:/class/Lshow";
	}
	
	
	
/*小类操作*/	
	
	@RequestMapping("Sshow")
	public String Sshow(Model model){
		List<SmallClass> list=smallClassServiceImpl.queryAll();
		for(SmallClass smallClass:list){
			System.out.println(smallClass);
		}
		model.addAttribute("list", list);
		return "book/small_class";
	}
	
	@RequestMapping("Sdel")
	public String Sdel(Model model,int id){
		smallClassServiceImpl.del(id);
		return "redirect:/class/Sshow";
	}
	
	@RequestMapping("SPreadd")
	public String SPreadd(Model model){
		model.addAttribute("list",largeClassServiceImpl.queryAll());
		List<LargeClass> ww=largeClassServiceImpl.queryAll();
		for(LargeClass largeClass:ww){
			System.out.println(largeClass);
		}
		return "book/small_add";
	}
	
	@RequestMapping("Sadd")
	public String Sadd(SmallClass smallClass){
		smallClassServiceImpl.add(smallClass);
	     return "redirect:/class/Sshow";
	}
	
	@RequestMapping("Spreupdate")
	public String Spreupdate(Model model,int id){
		System.out.println("前台传来的id为"+id);
	     model.addAttribute("list", smallClassServiceImpl.queryById(id));
	     model.addAttribute("large", largeClassServiceImpl.queryAll());
	     return "book/small_update";
	}
	
	@RequestMapping("Supdata")
	public String Spreupdate(Model model,SmallClass smallClass){
		smallClass.getLid();
		String Sname=smallClass.getName();//获取修改的小类名字 修改的同时修改book表中的小类名称
		smallClassServiceImpl.update(smallClass);
		bookServiceImpl.updataSmallName(Sname);
	   return "redirect:/class/Sshow";
	}
	
	
	
	
}
