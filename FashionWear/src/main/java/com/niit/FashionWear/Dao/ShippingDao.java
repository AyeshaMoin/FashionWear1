package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Shipping;

public interface ShippingDao {
	public boolean saveorupdate(Shipping ship);
	public boolean delete(Shipping ship);
	public Shipping get(String Shipping_Id);
	public List<Shipping> list();
	public List<Shipping> getaddbyUser(String userId);
	List<Shipping> getaddbyUser();

}
