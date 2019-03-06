package com.ssm.test;

import com.shop.mapper.BookMapper;
import com.shop.mapper.OrdersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class OrdersTest {


@Autowired
OrdersMapper ordersMapper;
BookMapper bookMaper;

/*	@Test
	public void QueryAll(){
		System.out.println("测试查询全部");
		
	List<Orders> orders=ordersMapper.queryAllById(2);
            for(Orders oo:orders){
           System.out.println(oo);
            }	    
	}*/
   @Test
	public void test(){
	System.out.println("测试");
	
bookMaper.updataLargeName("SDASD", "A");
	}
	
}	
	
	

	
