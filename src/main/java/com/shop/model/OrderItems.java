package com.shop.model;

public class OrderItems {

	private int id;
	
	private String orderId;
	
	private int bookId;
	
	private double price;
	
	private int num;
	
	private Book book; //一个订单详情号对应一个图书信息  一对一


	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	





	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", orderId=" + orderId + ", bookId=" + bookId + ", price=" + price + ", num="
				+ num + ", book=" + book + "]";
	}

	public OrderItems(int id, String orderId, int bookId, double price, int num) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookId = bookId;
		this.price = price;
		this.num = num;
	}

	public OrderItems() {
		super();
	}

	public OrderItems(String orderId, int bookId, double price, int num) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.price = price;
		this.num = num;
	}

	public OrderItems(int id, String orderId, int bookId, double price, int num, Book book) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookId = bookId;
		this.price = price;
		this.num = num;
		this.book = book;
	}


	
	
}
