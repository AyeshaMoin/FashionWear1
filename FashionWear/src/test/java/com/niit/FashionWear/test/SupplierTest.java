package com.niit.FashionWear.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.FashionWear.Dao.SupplierDao;
import com.niit.FashionWear.Model.Supplier;

public class SupplierTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Supplier supplier=(Supplier)ctx.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
		supplier.setSupId("s103");
		supplier.setName("supplier3");
		supplier.setAddress("About supplier3");
		supplier.setSph("9123456789");
		if(supplierDao.saveorupdate(supplier)==true) {
			System.out.println("supplier is saved successfully");
		}
		else
		{
			System.out.println("Supplier is not saved");
		}
		supplier=supplierDao.get("s101");
		if(supplierDao.delete(supplier)==true)
		{
			System.out.println("Supplier deleted");
		}
		else
		{
			System.out.println("Supplier not deleted");
		}
		supplier=supplierDao.get("s102");
		if(supplier==null) {
			System.out.println("Supplier not found");
		}
		else
		{
			System.out.println(supplier.getSupId());
			System.out.println(supplier.getName());
			System.out.println(supplier.getAddress());
			System.out.println(supplier.getSph());
		}
		
		}
}



