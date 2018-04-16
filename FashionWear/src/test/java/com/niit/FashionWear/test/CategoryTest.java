package com.niit.FashionWear.test;

import java.util.List;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Model.Category;

public class CategoryTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
	Category category=(Category)ctx.getBean("category");
		CategoryDao categoryDao=(CategoryDao)ctx.getBean("categoryDao");
	category.setCatId("c101");
		category.setCatName("category1");
		if(categoryDao.saveorupdate(category)==true) {
		System.out.println("category is saved successfully");
		}
		else		{
		System.out.println("category is not saved");
		}
		category.setCatId("c102");
		category.setCatName("category2");
		if(categoryDao.saveorupdate(category)==true) {
			System.out.println("category is saved successfully");
		}
		else
		{
		System.out.println("category is not saved");
		}
		category=categoryDao.get("c102");
		if(categoryDao.delete(category)==true)
		{
			System.out.println("Category deleted");
		}
		else
		{
			System.out.println("Category not deleted");
		}
		category=categoryDao.get("c103");
		if(category==null) {
			System.out.println("Category not found");
		}
		else
		{
			System.out.println(category.getCatId());
			System.out.println(category.getCatName());
		}
		List<Category> cat=categoryDao.list();
		for(Category c:cat)
		{
			System.out.println(c.getCatId());
			System.out.println(c.getCatName());		}
		
		}
}
