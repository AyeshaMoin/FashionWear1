package com.niit.FashionWear.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Dao.ProductDao;
import com.niit.FashionWear.Dao.SupplierDao;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Product;
import com.niit.FashionWear.Model.Supplier;

public class ProductTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Product product=(Product)ctx.getBean("product");
		ProductDao productDao=(ProductDao)ctx.getBean("productDao");
		Category category=(Category)ctx.getBean("category");
		CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
		category=categoryDao.get("c101");
//		product.setCategory(category);
		Supplier supplier=(Supplier)ctx.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)ctx.getBean("supplierDao");
		supplier=supplierDao.get("s102");
//		product.setSupplier(supplier);
		product.setProId("p101");
		product.setName("product1");
		product.setDescription("About Product1");
		product.setPrice(5000);
		product.setQuantity(8);
		if(productDao.saveorupdate(product)==true) {
			System.out.println("product is saved successfully");
		}
		else
		{
			System.out.println("product is not saved");
		}
		
		product.setProId("p101");
		product.setName("product1");
		product.setDescription("About Product1");
		product.setPrice(5000);
		product.setQuantity(8);
		if(productDao.saveorupdate(product)==true) {
			System.out.println("product is saved successfully");
		}
		else
		{
			System.out.println("product is not saved");
		}
		
		product=productDao.get("p102");
		if(productDao.delete(product)==true)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not deleted");
		}
		product=productDao.get("p103");
		if(product==null) {
			System.out.println("Product not found");
		}
		else
		{
			System.out.println(product.getProId());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
			System.out.println(product.getQuantity());
		
		}
}

}
