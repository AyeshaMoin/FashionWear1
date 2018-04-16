package com.niit.FashionWear.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	@Id
	private String SupId;
	private String Name;
	private String Phone;
	private String Address;
	private String Email;
	@OneToMany(mappedBy="supplier",cascade=CascadeType.ALL)
	private List<Product>product;
	public Supplier()
	{
		this.SupId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
    }
     
    public List<Product> getProduct() {
    	return product;
    }
    public void setProduct(List<Product> product) {
    	this.product=product;
    }
	public String getSph() {
		return Phone;
	}
	public void  setSph(String sph) {
		this.Phone=sph;
	}
	public String getSupId() {
		return SupId;
	}
	public void setSupId(String supId) {
		SupId = supId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	}
	
	
	

	
	
	

