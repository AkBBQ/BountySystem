package com.shop.service;

import com.shop.mapper.LargeClassMapper;
import com.shop.model.LargeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LargeClassServiceImpl implements LargeClassService {

	@Autowired
	LargeClassMapper largeClassMapper;
	
	public List<LargeClass> queryAll() {
		// TODO Auto-generated method stub
		return largeClassMapper.queryAll();
	}

	public void add(LargeClass largeClass) {
		// TODO Auto-generated method stub
		 largeClassMapper.add(largeClass);
		
	}

	public void del(int id) {
		largeClassMapper.del(id);
		
	}

	public void update(LargeClass largeClass) {
		largeClassMapper.update(largeClass);
		
	}

	public LargeClass queryById(int id) {
		// TODO Auto-generated method stub
		return largeClassMapper.queryById(id);
	}

	
}
