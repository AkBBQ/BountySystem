package com.shop.mapper;

import com.shop.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
  public List<Book> queryAll(Book book);//查询全部  可以带条件书名模糊查询

  public void add(Book book); //添加图书
  
  public void del(int id);//根据id删除
  
  public Book queryById(int id);//编辑时候根据Id查到值到前台进行显示
  
  public void updata(Book book);//修改
  
  public void updataLargeName(@Param("A") String a, @Param("B") String b);//当大类表中的地段修改的时候,修改book表中对应的大类名称
  
  public void updataSmallName(String name);//当大类表中的地段修改的时候,修改book表中对应的小类名称
  
  public List<Book> queryHot(int num);//查询首页的热卖图书           num为显示的条数
  
  public List<Book> queryRecommend(int num);//查询首页的推荐图书  num为显示的条数
  
  
  
}