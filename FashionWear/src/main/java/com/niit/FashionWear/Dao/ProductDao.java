package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Product;

public interface ProductDao {
	public boolean saveorupdate(Product pro);
	public boolean delete(Product pro);
	public Product get(String ProId);
	public List<Product> list();
	public List<Product> getProductByCategory(String id);

}
