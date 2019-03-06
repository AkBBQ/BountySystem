package com.shop.controller;

import com.shop.service.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/")
public class IndexController {

@Resource
BookServiceImpl bookServiceImpl;
	
	@RequestMapping(value="index")
	public String index(Model model) {
		//查询6本热卖图书
		model.addAttribute("hot", this.bookServiceImpl.queryHot(6));
		//查询4本推荐图书
		model.addAttribute("recommend", this.bookServiceImpl.queryRecommend(4));
		return "main";
	}
	
}
