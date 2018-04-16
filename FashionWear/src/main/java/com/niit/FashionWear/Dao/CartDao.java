package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Cart;

public interface CartDao {
	public boolean saveorupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart get(String Cart_Id);
	public List<Cart> list();
	

}
