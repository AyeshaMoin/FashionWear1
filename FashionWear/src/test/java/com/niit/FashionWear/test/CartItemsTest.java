package com.niit.FashionWear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.FashionWear.Dao.CartItemsDao;
import com.niit.FashionWear.Model.CartItems;


public class CartItemsTest {
	
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		CartItems cartit=(CartItems)ctx.getBean("cartItems");
		CartItemsDao cartitDao=(CartItemsDao)ctx.getBean("CartItemsDao");
		cartit.setCartitems_Id("cai101");
		cartit.setPrice(56);
		if(cartitDao.saveorupdate(cartit)==true) {
			System.out.println("cartItem is saved successfully");
		}
		else
		{
			System.out.println("cartItem is not saved");
		}
		cartit=cartitDao.get("cai101");
		if(cartitDao.delete(cartit)==true)
		{
			System.out.println("Cartitem deleted");
		}
		else
		{
			System.out.println("Cartitem not deleted");
		}
		cartit=cartitDao.get("cai101");
		if(cartit==null) {
			System.out.println("CartItem not found");
		}
		else
		{
			System.out.println(cartit.getCartitem_Id());
			System.out.println(cartit.getPrice());
		}
		
		}
}

