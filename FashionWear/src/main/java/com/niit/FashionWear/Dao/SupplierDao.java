package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Supplier;

public interface SupplierDao {
	public boolean saveorupdate(Supplier sup);
	public boolean delete(Supplier sup);
	public Supplier get(String SupId);
	public List<Supplier> list();

}
