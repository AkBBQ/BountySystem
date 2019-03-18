package com.shop.service;

import com.shop.mapper.SmallClassMapper;
import com.shop.model.SmallClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmallClassServiceImpl implements SmallClassService {

	@Autowired
	SmallClassMapper smallClassMapper;

	public List<SmallClass> queryAll() {
		// TODO Auto-generated method stub
		return smallClassMapper.queryAll();
	}

	public void add(SmallClass smallClass) {
		// TODO Auto-generated method stub
		smallClassMapper.add(smallClass);
		
	}

	public void del(int id) {
		// TODO Auto-generated method stub
		smallClassMapper.del(id);
		
	}

	public void update(SmallClass smallClass) {
		// TODO Auto-generated method stub
		smallClassMapper.update(smallClass);
		
	}

	public SmallClass queryById(int id) {
		// TODO Auto-generated method stub
		return smallClassMapper.queryById(id);
	}

	public List<SmallClass> querySmallname(String name) {
		// TODO Auto-generated method stub
		return smallClassMapper.querySmallname(name);
	}
	
	

	
}
