package com.shop.model;

import java.util.Date;

public class Orders {

	private int id;
	
	private int userId;
	
	private String  username;
	
	private String address;
	
	private String phone;
	
	private char status; //订单状态
	
	private Date shipDate;//发货日期
	
	private Date orderDate; //下单日期
	
	private String orderId;//随机订单号
	

	
	/*  private List<OrderItems> orderItems;            //一个订单对应多个 订单详情   一对多 collection  

	  
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}*/

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", username=" + username + ", address=" + address
				+ ", phone=" + phone + ", status=" + status + ", shipDate=" + shipDate + ", orderDate=" + orderDate
				+ ", orderId=" + orderId + "]";
	}

	public Orders(int id, int userId, String username, String address, String phone, char status, Date shipDate,
			Date orderDate, String orderId) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.shipDate = shipDate;
		this.orderDate = orderDate;
		this.orderId = orderId;
	}

	public Orders() {
		super();
	}






	
	
	
}
