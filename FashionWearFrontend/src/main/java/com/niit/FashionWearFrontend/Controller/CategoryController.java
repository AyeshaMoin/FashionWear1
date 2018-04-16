package com.niit.FashionWearFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Dao.ProductDao;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Product;
@Controller
public class CategoryController 
{
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;
@Autowired
Product product;
@Autowired
ProductDao productDao;
@RequestMapping("/category")
public ModelAndView category()
{
	ModelAndView obj=new ModelAndView("Category");
	obj.addObject("category",new Category());
	List<Category> lc=categoryDao.list();
	obj.addObject("categories",lc);

	return obj;
}
@RequestMapping("/addcat")
public ModelAndView addcat(@ModelAttribute("category")Category category)
{
	ModelAndView obj=new ModelAndView("redirect:/category");
	if(categoryDao.saveorupdate(category)==true)
	{
		obj.addObject("msg1","Category added successfully");
	}
	else
	{
		obj.addObject("msg2","Category not added");
	}
return obj;
}
@RequestMapping("/editCategory/{catId}")
public ModelAndView editcat(@PathVariable("catId") String id)
{
	List<Category> categories=categoryDao.list();
	ModelAndView obj=new ModelAndView("Category");
	category=categoryDao.get(id);
	obj.addObject("category", category);
	obj.addObject("categories",categories);
	return obj;
}
@RequestMapping("/deleteCategory/{catId}")
public ModelAndView delete(@PathVariable("catId") String id)
{
	ModelAndView obj=new ModelAndView("redirect:/category");
	category=categoryDao.get(id);
	obj.addObject("category",new Category());
	List<Product> lp=productDao.getProductByCategory(id);
	if(lp==null||lp.isEmpty())
	{
		categoryDao.delete(category);
	obj.addObject("msg1","category deleted successfully");
}
else
{
	for(Product p:lp)
	{
		productDao.delete(p);
	}
	categoryDao.delete(category);
	obj.addObject("msg","Category and list of products deleted");
	
}
return obj;
}
}
