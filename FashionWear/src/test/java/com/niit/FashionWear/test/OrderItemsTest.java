

package com.niit.FashionWear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.FashionWear.Dao.OrderItemsDao;
import com.niit.FashionWear.Model.OrderItems;

public class OrderItemsTest {
	public static void main(String args[])
	{
	

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		OrderItems orderitems=(OrderItems)ctx.getBean("orderItems");
		OrderItemsDao orderitemsDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
		orderitems.setOrderitem_Id("oi101");
		orderitems.setProduct_Id("5489");
		if(orderitemsDao.saveorupdate(orderitems)==true) {
			System.out.println("orderItem is saved successfully");
		}
		else
		{
			System.out.println("orderItem is not saved");
		}
		orderitems=orderitemsDao.get("oi101");
		if(orderitems.delete(orderitems)==true)
		{
			System.out.println("Orderitems deleted");
		}
		else
		{
			System.out.println("Orderitems not deleted");
		}
		orderitems=orderitemsDao.get("oi101");
		if(orderitems==null) {
			System.out.println("OrderItems not found");
		}
		else
		{
			System.out.println(orderitems.getOrderitem_Id());
			System.out.println(orderitems.getProduct_Id());
		}
		
		}
}



