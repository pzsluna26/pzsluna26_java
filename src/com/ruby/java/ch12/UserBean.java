package com.ruby.java.ch12;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID =123;
	public void tes() {}
	private String id;
	private String name;
	private String tel;
	private String address;
	
	public void UserBean() {
}
public UserBean(String id, String name, String tel, String address) {
	super();
	this.id = id;
	this.name = name;
	this.tel =tel;
	this.address =address;
	
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
		return "UserBean1 [id="+id+", name="+name+", tel="+tel+",address="+address+"]";
	}
}

