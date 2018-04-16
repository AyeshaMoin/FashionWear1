package com.niit.FashionWear.Model;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
@Id
private String proId;
private String Name;
private String Description;
private double Price;
private int Quantity;
   @Transient
private MultipartFile pimg;

public MultipartFile getPimg() {
	return pimg;
}
public void setPimg(MultipartFile pimg) {
	this.pimg = pimg;
}
@ManyToOne
@JoinColumn(name="catId")
private Category category;
@ManyToOne
@JoinColumn(name="SupId")
private Supplier supplier;
public Product()
{
	this.proId="PRODUCT"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
public String getProId() {
	return proId;
}
public void setProId(String proId) {
	this.proId = proId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
	

}