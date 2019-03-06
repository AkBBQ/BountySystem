package com.shop.model;

import java.util.Date;

public class Book {
    private Integer id;

    private String superType;

    private String subType;

    private String name;

    private String isbn;

    private String introduce;

    private Float price;

    private Float nowPrice;

    private String photo;

    private Integer pages;

    private String publisher;

    private String author;

    private String newBook;

    private String saleBook;

    private String specialBook;

    private String recommendBook;

    private Date addDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuperType() {
        return superType;
    }

    public void setSuperType(String superType) {
        this.superType = superType == null ? null : superType.trim();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(Float nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getNewBook() {
        return newBook;
    }

    public void setNewBook(String newBook) {
        this.newBook = newBook == null ? null : newBook.trim();
    }

    public String getSaleBook() {
        return saleBook;
    }

    public void setSaleBook(String saleBook) {
        this.saleBook = saleBook == null ? null : saleBook.trim();
    }

    public String getSpecialBook() {
        return specialBook;
    }

    public void setSpecialBook(String specialBook) {
        this.specialBook = specialBook == null ? null : specialBook.trim();
    }

    public String getRecommendBook() {
        return recommendBook;
    }

    public void setRecommendBook(String recommendBook) {
        this.recommendBook = recommendBook == null ? null : recommendBook.trim();
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

	public Book(Integer id, String superType, String subType, String name, String isbn, String introduce, Float price,
			Float nowPrice, String photo, Integer pages, String publisher, String author, String newBook,
			String saleBook, String specialBook, String recommendBook, Date addDate) {
		super();
		this.id = id;
		this.superType = superType;
		this.subType = subType;
		this.name = name;
		this.isbn = isbn;
		this.introduce = introduce;
		this.price = price;
		this.nowPrice = nowPrice;
		this.photo = photo;
		this.pages = pages;
		this.publisher = publisher;
		this.author = author;
		this.newBook = newBook;
		this.saleBook = saleBook;
		this.specialBook = specialBook;
		this.recommendBook = recommendBook;
		this.addDate = addDate;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", superType=" + superType + ", subType=" + subType + ", name=" + name + ", isbn="
				+ isbn + ", introduce=" + introduce + ", price=" + price + ", nowPrice=" + nowPrice + ", photo=" + photo
				+ ", pages=" + pages + ", publisher=" + publisher + ", author=" + author + ", newBook=" + newBook
				+ ", saleBook=" + saleBook + ", specialBook=" + specialBook + ", recommendBook=" + recommendBook
				+ ", addDate=" + addDate + "]";
	}
    
    
}