package com.shop.model;

public class Cart {

	private int id;
	
	private int userId;
	
	private int bookId;
	
	private int num;
	
	private Book book; //一对一关联查询  一个购物车bookid对应一个book表中的id
	
	

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", num=" + num + ", book=" + book + "]";
	}

	public Cart(int id, int userId, int bookId, int num, Book book) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.num = num;
		this.book = book;
	}

	public Cart() {
		super();
	}

	public Cart(int bookId) {
		super();
		this.bookId = bookId;
	}

	public Cart(int id, int userId, int bookId, int num) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.num = num;
	}


	
	
	
}
