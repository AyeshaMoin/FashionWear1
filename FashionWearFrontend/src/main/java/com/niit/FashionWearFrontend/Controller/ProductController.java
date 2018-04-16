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
import com.niit.FashionWear.Fileinput.Fileinput;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Product;
import com.niit.FashionWear.Model.Supplier;

@Controller
public class ProductController {
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;
@Autowired
Supplier supplier;
@Autowired
SupplierDao supplierDao;
String path="C:\\Users\\$YED\\eclipse-workspace\\FashionWearFrontend\\src\\main\\webapp\\resources\\images\\";
@RequestMapping("/product")
public ModelAndView product() {
	ModelAndView obj=new ModelAndView ("Product");
	obj.addObject("product", new Product());
	List<Product> lc=productDao.list();
	List<Category> li=categoryDao.list();
	List<Supplier> ls=supplierDao.list();
	obj.addObject("categories",li);
	obj.addObject("products",lc);
	obj.addObject("suppliers",ls);
	obj.addObject("lcat",li);
	return obj;
}
@RequestMapping("/addpro")
public ModelAndView addpro(@ModelAttribute("product")Product pro) {
	ModelAndView obj=new ModelAndView("redirect:/product");
	if(productDao.saveorupdate(pro)==true)
	{
	Fileinput.upload(path,pro.getPimg(),pro.getProId()+".jpg");
		obj.addObject("msg1","Product added successfully");
	}
	else
	{
		obj.addObject("msg2","Product not added");
		
	}
	return obj;
	
}
@RequestMapping("/editProduct/{ProId}")
public ModelAndView edit(@PathVariable("ProId")String id) {
	ModelAndView obj=new ModelAndView("Product");
	product=productDao.get(id);
	 obj.addObject("product",product);
	 List<Category> li=categoryDao.list();
	 obj.addObject("categories",li);
	 List<Supplier> ls=supplierDao.list();
	 obj.addObject("suppliers",ls);
	 List<Product> products=productDao.list();
	 obj.addObject("products",products);
	 return obj;
}	 
	
@RequestMapping("/deleteProduct/{ProId}")
public ModelAndView delete(@PathVariable("ProId")String id) {
	ModelAndView obj=new ModelAndView("redirect:/product");
	product=productDao.get(id);
	productDao.delete(product);
	 return obj;
}	
}
	
	
	
	
	
	
	
	


