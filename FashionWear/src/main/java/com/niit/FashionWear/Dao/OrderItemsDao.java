package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.OrderItems;

public interface OrderItemsDao {
	public boolean saveorupdate(OrderItems orderitems);
	public boolean delete(OrderItems orderitems);
	public OrderItems get(String Orderitem_Id);
	public List<OrderItems> list();

}
