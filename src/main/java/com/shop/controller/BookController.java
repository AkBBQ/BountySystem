package com.shop.controller;

import com.shop.model.Book;
import com.shop.model.SmallClass;
import com.shop.service.BookServiceImpl;
import com.shop.service.LargeClassServiceImpl;
import com.shop.service.SmallClassServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("book")
public class BookController {

	@Resource
	BookServiceImpl bookServiceImpl;
	@Resource
	LargeClassServiceImpl LargeClassServiceImpl;
    @Resource
    SmallClassServiceImpl smallClassServiceImpl;
	
	//后台查询所有图书
	@RequestMapping("list")
	public String queryall(Integer currPage, Book book, Model model){
		model.addAttribute("page", bookServiceImpl.queryAll(currPage, book));
		//注意查到的数据是page.list 所以前台遍历要使用${page.list}
		
		return "book/book_list";
	}
	
	//增加之前先把大类信息传到前台介面取
	@RequestMapping("BperAdd")
	public String BperAdd(Model model){
		model.addAttribute("Large",LargeClassServiceImpl.queryAll());
		return "book/book_add";
		
	}
	
	@RequestMapping("Badd")
	public String Badd(@RequestParam("myFile") MultipartFile file, Book book, HttpSession session){
		/*System.out.println("前台传来的大类名字为:"+book.getSuperType());
		System.out.println("前台传来的小类名字为:"+book.getSubType());*/
		String fileName = file.getOriginalFilename();
		
		//添加图片到指定路径并且把图片名字经过处理添加到数据库中
		if(!fileName.equals("")) {
			String newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
			/*String path = session.getServletContext().getRealPath("upload") + "\\" + newFileName;*/
			File newFile = new File("F:\\upload\\images"+ "\\" + newFileName);
			try {
			/*	FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));*/
				FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
				
				book.setPhoto(newFileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bookServiceImpl.add(book);
		return "redirect:/book/list";
		
	}
	
	@RequestMapping("Bdel")
	public String Bdel(int id){
		bookServiceImpl.del(id);
		return "redirect:/book/list";
	}
	
	/*二级联动 选择大类之后显示其小类的信息*/
	
	@RequestMapping("showSmall")
	@ResponseBody
	public List<SmallClass> Sshow(String name){
		System.out.println("Ajax传过来的值为"+name);
		List<SmallClass> list=smallClassServiceImpl.querySmallname(name);
		for(SmallClass smallClass:list){
			System.out.println(smallClass);
		}
		return list;
	}
	
	@RequestMapping("BreUpdate")
	public String BreUpdate(int id,Model model){
		model.addAttribute("list", bookServiceImpl.queryById(id));
		model.addAttribute("Large",LargeClassServiceImpl.queryAll());//修改大类  查出所有大类名称用来选择
		return "book/book_update";
		
	}
	
	@RequestMapping("BUpdate")
	public String BUpdate(Book book, Model model){
		System.out.println("前台传来的id为"+book.getId());
		bookServiceImpl.updata(book);
		return "redirect:/book/list";
		
	}
	
	
	//前台------------------------------------------------
	
	/*点击图书 根据传来的id 跳到购物车显示详情*/
	@RequestMapping("bookInfo")
	public String bookInfo(int id,Model model){
		model.addAttribute("list",bookServiceImpl.queryById(id));
          return "single";
	}
	
	//后台查询所有图书,查询分类图书
		@RequestMapping("showList")
		public String queryAll(Integer currPage, Book book, Model model){
			//注意查到的数据是page.list 所以前台遍历要使用${page.list}
			model.addAttribute("page", bookServiceImpl.queryAll(currPage, book));
			//查到所有大类名称
			model.addAttribute("large", LargeClassServiceImpl.queryAll());
			return "bookshop";
		}
}
