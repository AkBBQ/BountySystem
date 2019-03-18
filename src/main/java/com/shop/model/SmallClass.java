package com.shop.model;

public class SmallClass {

	private int id;
	
	private int lid;//所属的大类id
	
	private String name;//小类名称
	
	private LargeClass largeClass; //多对一关联查询    一个小类只能对应一个大类
	
	

	public LargeClass getLargeClass() {
		return largeClass;
	}

	public void setLargeClass(LargeClass largeClass) {
		this.largeClass = largeClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SmallClass [id=" + id + ", lid=" + lid + ", name=" + name + ", largeClass=" + largeClass + "]";
	}

	
	
	

	
	
	
	
}
