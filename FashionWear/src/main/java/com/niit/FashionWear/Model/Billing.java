package com.niit.FashionWear.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Billing {
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id
	private String Bill_Id;
	private String House_No;
	private String Country;
	private String City;
	private String Pincode;
	private String Email;
	private String Mobile_No;
	@OneToOne
	@JoinColumn(name="UserId")
	private User user;
	public Billing()
	{
		this.Bill_Id="BILL"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getBill_Id() {
		return Bill_Id;
	}
	public void setBill_Id(String bill_Id) {
		Bill_Id = bill_Id;
	}
	public String getHouse_No() {
		return House_No;
	}
	public void setHouse_No(String house_No) {
		House_No = house_No;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile_No() {
		return Mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	}
	
		
	}
	

