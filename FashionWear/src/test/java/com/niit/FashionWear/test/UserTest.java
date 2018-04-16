package com.niit.FashionWear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.FashionWear.Dao.UserDao;
import com.niit.FashionWear.Model.User;

public class UserTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		user.setUserId("u102");
		user.setName("user");
		user.setHouse_No("83");
		user.setCity("Bangalore");
		user.setPincode("560097");
		user.setMobile_No("9123456789");
		user.setEmail("ayesha@gmail.com");
		user.setPassword("moin");
		if(userDao.saveorupdate(user)==true) {
			System.out.println("User is saved successfully");
		}
		else
		{
			System.out.println("User is not saved");
		}
		user=userDao.get("u102");
		if(user==null) {
			System.out.println("User not found");
		}
		else
		{
			System.out.println(user.getUserId());
			System.out.println(user.getName());
	        System.out.println(user.getHouse_No());
	        System.out.println(user.getCity());
			System.out.println(user.getMobile_No());
			System.out.println(user.getEmail());
			System.out.println(user.getPincode());
			System.out.println(user.getPassword());
		}
		
		}
}



