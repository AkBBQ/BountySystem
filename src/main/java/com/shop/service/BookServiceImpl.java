package com.shop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.BookMapper;
import com.shop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
    BookMapper bookMapper;

	public PageInfo<Book> queryAll(Integer currPage, Book book) {
		// TODO Auto-generated method stub
		if(currPage == null) currPage=1;		
		PageHelper.startPage(currPage, 6);//每页查4条数据
		PageInfo<Book> pageInfo=new PageInfo<Book>(bookMapper.queryAll(book));
		return pageInfo ;
	}

	public void add(Book book) {
		bookMapper.add(book);
		
	}

	public void del(int id) {
		bookMapper.del(id);
		
	}

	public Book queryById(int id) {
		// TODO Auto-generated method stub
		return bookMapper.queryById(id);
	}

	public void updata(Book book) {
		// TODO Auto-generated method stub
		bookMapper.updata(book);
		
	}

/*	public void updataLargeName(Book book) {
		// TODO Auto-generated method stub
		bookMapper.updataLargeName(book);
		
	}*/

	public void updataSmallName(String name) {
		// TODO Auto-generated method stub
		bookMapper.updataSmallName(name);
		
	}

	public List<Book> queryHot(int num) {
		// TODO Auto-generated method stub
		return bookMapper.queryHot(num);
	}

	public List<Book> queryRecommend(int num) {
		// TODO Auto-generated method stub
		return bookMapper.queryRecommend(num);
	}

	

}
