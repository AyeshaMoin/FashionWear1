package com.niit.FashionWear.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.FashionWear.Dao.BillingDao;
import com.niit.FashionWear.Dao.UserDao;
import com.niit.FashionWear.Model.Billing;
import com.niit.FashionWear.Model.User;

public class BillingTest {
	
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billingDao=(BillingDao)ctx.getBean("billingDao");User user=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		user=userDao.get("u102");
		bill.setUser(user);
		bill.setBill_Id("b104");
		bill.setHouse_No("35");
		bill.setCountry("India");
		bill.setCity("Bangalore");
		bill.setPincode("560056");
		bill.setEmail("p@gmail.com");
		bill.setMobile_No("9876543210");
		if(billingDao.saveorupdate(bill)==true) {
			System.out.println("Bill is saved successfully");
		}
		else
		{
			System.out.println("Bill is not saved");
		}
		
		bill=billingDao.get("b101");
		if(billingDao.delete(bill)==true)
		{
			System.out.println("Bill deleted");
		}
		else
		{
			System.out.println("Bill not deleted");
		}
		bill=billingDao.get("b102");
		if(bill==null) {
			System.out.println("Bill not found");
		}
		else
		{
			System.out.println(bill.getBill_Id());
			System.out.println(bill.getHouse_No());
			System.out.println(bill.getCountry());
			System.out.println(bill.getCity());
			System.out.println(bill.getPincode());
			System.out.println(bill.getEmail());
			System.out.println(bill.getMobile_No());
			
		}
		
		
		}
}
