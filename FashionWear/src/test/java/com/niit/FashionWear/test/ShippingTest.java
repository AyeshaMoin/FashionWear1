package com.niit.FashionWear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.FashionWear.Dao.ShippingDao;
import com.niit.FashionWear.Model.Shipping;

public class ShippingTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Shipping ship=(Shipping)ctx.getBean("shipping");
		ShippingDao shipDao=(ShippingDao)ctx.getBean("shippingDao");
		ship.setShipping_Id("sh103");
		ship.setHouse_No("35");
		ship.setCountry("India");
		ship.setCity("bangalore");
		ship.setPinCode("560056");
		ship.setEmail("p@gmail.com");
		ship.setMobile_No("91234567810");
		ship.setFirst_Name("Ayesha");
		ship.setLast_Name("Mohiddin");
		if(shipDao.saveorupdate(ship)==true) {
			System.out.println("Ship is saved successfully");
		}
		else
		{
			System.out.println("Ship is not saved");
		}
		ship=shipDao.get("sh101");
		if(shipDao.delete(ship)==true)
		{
			System.out.println("Ship deleted");
		}
		else
		{
			System.out.println("Ship not deleted");
		}
		ship=shipDao.get("sh101");
		if(ship==null) {
			System.out.println("Ship not found");
		}
		else
		{
			System.out.println(ship.getShipping_Id());
			System.out.println(ship.getHouse_No());
			System.out.println(ship.getCountry());
			System.out.println(ship.getCity());
			System.out.println(ship.getPinCode());
			System.out.println(ship.getEmail());
			System.out.println(ship.getMobile_No());
			System.out.println(ship.getFirst_Name());
			System.out.println(ship.getLast_Name());
		}
		
		}
}





