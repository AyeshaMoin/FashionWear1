package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.Authentication;


public interface AuthenticationDao {
	public boolean saveorupdate(Authentication auth);
	public boolean delete(Authentication auth);
	public Authentication get(String role_id);
	public List<Authentication> list();

}
