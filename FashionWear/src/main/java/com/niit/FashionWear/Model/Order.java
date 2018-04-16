package com.niit.FashionWear.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")
@Component
public class Order {
	@Id
	private String Order_Id;
	private double Grand_Total;
	private String Order_Date;
	private String Order_Time;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Bill_Id")
	private Billing billing;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Shipping_Id")
	private Shipping shipping;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UserId")
	private User user;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Pay_Id")
	private Pay pay;
	@OneToMany(mappedBy="order")
	private List<OrderItems> orderItems;
	public Order()
	{
		this.Order_Id="ORDER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing)
	{
		this.billing=billing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping)
	{
		this.shipping=shipping;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user)
	{
		this.user=user;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay)
	{
		this.pay=pay;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	
	}
	public void setOrderItems(List<OrderItems> orderitems) {
		this.orderItems=orderitems;
	}
	public String getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}
	public double getGrand_Total() {
		return Grand_Total;
	}
	public void setGrand_Total(double grand_Total) {
		Grand_Total = grand_Total;
	}
	public String getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}
	public String getOrder_Time() {
		return Order_Time;
	}
	public void setOrder_Time(String order_Time) {
		Order_Time = order_Time;
	}
	
	

}
