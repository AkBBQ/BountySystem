package com.shop.model;

import java.util.Date;

public class Users {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String realname;

    private String sex;

    private Date birthday;

    private String address;

    private String postcode;

    private String phone;

    private String type;

    private Date addDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Users(Integer id, String username, String password, String email, String realname, String sex, Date birthday,
			String address, String postcode, String phone, String type, Date addDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.postcode = postcode;
		this.phone = phone;
		this.type = type;
		this.addDate = addDate;
	}

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", realname=" + realname + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address
				+ ", postcode=" + postcode + ", phone=" + phone + ", type=" + type + ", addDate=" + addDate + "]";
	}


    
    
}