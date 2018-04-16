package com.niit.FashionWear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.FashionWear.Dao.CartDao;
import com.niit.FashionWear.Model.Cart;

public class CartTest {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Cart cart=(Cart)ctx.getBean("cart");
		CartDao cartDao=(CartDao)ctx.getBean("cartDao");
		cart.setCart_Id("ca102");
		cart.setGrand_Total(36.0);
		cart.setTotal_Items(7);
		if(cartDao.saveorupdate(cart)==true) {
			System.out.println("cart is saved successfully");
		}
		else
		{
			System.out.println("cart is not saved");
		}
		cart=cartDao.get("ca101");
		if(cartDao.delete(cart)==true)
		{
			System.out.println("Cart deleted");
		}
		else
		{
			System.out.println("Cart not deleted");
		}
		cart=cartDao.get("ca101");
		if(cart==null) {
			System.out.println("Cart not found");
		}
		else
		{
			System.out.println(cart.getCart_Id());
			System.out.println(cart.getGrand_Total());
			System.out.println(cart.getTotal_Items());
		}
		
		}
}



