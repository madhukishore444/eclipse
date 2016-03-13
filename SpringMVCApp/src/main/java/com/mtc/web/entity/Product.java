package com.mtc.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producttable11")
//@Table(name="pro_new")
public class Product implements Serializable {
	@Id
	@Column(name="product_id")
	private  int id;
	@Column(name="product_name")
	private String name;
	@Column(name="product_desc")
	private String desc;
	@Column(name="product_price")
	private float price;
	/*
	@OneToMany
	@JoinColumn(name="supplier_id")
	private Supplier supplier;*/
public Product(int id, String name, float price,String desc) {
	super();
	this.id = id;
	this.name = name;
	this.desc = desc;
	this.price = price;
}
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
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Product() {
	// TODO Auto-generated constructor stub
}
}
