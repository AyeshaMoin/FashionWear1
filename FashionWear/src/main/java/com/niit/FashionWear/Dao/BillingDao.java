package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Billing;

public interface BillingDao {
	public boolean saveorupdate(Billing bil);
	public boolean delete(Billing bil );
	public Billing get(String UserId);
	public List<Billing> list();
}
