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
import com.niit.FashionWear.Dao.SupplierDao;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Product;
import com.niit.FashionWear.Model.Supplier;

@Controller
public class SupplierController {
@Autowired
Supplier supplier;
@Autowired
SupplierDao supplierDao;
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;


@RequestMapping("/Supplier")
public ModelAndView Supplier()
{
	ModelAndView obj=new ModelAndView("Supplier");
	obj.addObject("supplier",new Supplier());
	List<Supplier> li=supplierDao.list();
	obj.addObject("Suppliers",li);
	List<Category> categories=categoryDao.list();
	obj.addObject("lcat",categories);
	return obj;
}
@RequestMapping("/addsup")
public ModelAndView addsup(@ModelAttribute("supplier")Supplier supplier)
{
	ModelAndView obj=new ModelAndView("redirect:/Supplier");
	if(supplierDao.saveorupdate(supplier)==true)
	{
		obj.addObject("msg1","Supplier added successfully");
	}
	else
	{
		obj.addObject("msg2","Supplier not added");
	}
return obj;
}

@RequestMapping("/editSupplier/{sid}")
public ModelAndView edit(@PathVariable("sid") String id)
{
	List<Supplier> suppliers=supplierDao.list();
	ModelAndView obj=new ModelAndView("Supplier");
	supplier=supplierDao.get(id);
	obj.addObject("supplier",supplier);
	obj.addObject("Suppliers",suppliers);
	return obj;
}

@RequestMapping("/deleteSupplier/{sid}")
public ModelAndView delete(@PathVariable("sid") String id) 
{
	
	ModelAndView obj=new ModelAndView("redirect:/Supplier");
	supplier=supplierDao.get(id);
	List<Product> lp=productDao.list();
	
	if(lp==null || lp.isEmpty()) {
		supplierDao.delete(supplier);
		obj.addObject("msg1","Supplier deleted successfully");
		
	}
	else
	{
		for(Product p:lp) {
			productDao.delete(p);
			
		}
		supplierDao.delete(supplier);
		obj.addObject("msg","Supplier and list of products deleted");
		
	}
	return obj;
}
}
