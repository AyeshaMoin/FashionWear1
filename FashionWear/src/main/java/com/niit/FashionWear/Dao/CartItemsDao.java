package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Cart;
import com.niit.FashionWear.Model.CartItems;

public interface CartItemsDao {
	public boolean saveorupdate(CartItems cartit);
	public boolean delete(CartItems cartitems);
	public CartItems get(String Cartitems_Id);
	public List<CartItems> list();
	public List<CartItems> getlist(String cart_Id);
	public CartItems getlistall(String cart_Id, String proId);

}
