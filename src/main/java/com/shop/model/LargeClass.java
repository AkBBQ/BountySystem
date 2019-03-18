package com.shop.model;

public class LargeClass {

	private int id;
	private String name; //大类名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LargeClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public LargeClass() {
		super();
	}
	@Override
	public String toString() {
		return "LargeClass [id=" + id + ", name=" + name + "]";
	}
	
	
}
