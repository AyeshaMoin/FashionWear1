package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Order;

public interface OrderDao {
	public boolean saveorupdate(Order ord);
	public boolean delete(Order ord);
	public Order get(String Order_Id);
	public List<Order> list();

}
