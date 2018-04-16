package com.niit.FashionWear.Dao;

import java.util.List;

import com.niit.FashionWear.Model.User;

public interface UserDao {
	public boolean saveorupdate(User user);
	public boolean delete(User user);
	public User get(String UserId);
	public List<User> list();
	public User getUseremail(String currusername);		
	public User isValid(String umail, String pwd);

}
