package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Pay;

public interface PayDao {
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay get(String Pay_Id);
	public List<Pay> list();

}
