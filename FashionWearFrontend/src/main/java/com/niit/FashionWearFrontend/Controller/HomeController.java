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
import com.niit.FashionWear.Model.Product;
import com.niit.FashionWear.Model.Category;


@Controller
public class HomeController {
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;
@RequestMapping("/products")
public ModelAndView product()
{
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	ModelAndView obj=new ModelAndView("product");
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}

@RequestMapping("/")
public ModelAndView home()
{
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	ModelAndView obj=new ModelAndView("home");
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}
@RequestMapping("/Home")
public ModelAndView home1()
{
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	ModelAndView obj=new ModelAndView("home");
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}

@RequestMapping("/Category")
public String Category()
{
	return "Category";
}
//@RequestMapping("/product")
//public String Product()
//{
//	return "Product";
//}
//@RequestMapping("/Supplier")
//public String Supplier()
//{
//	return "Supplier";
//}
@RequestMapping("/Login")
public String Login()
{
	return "Login";
}
@RequestMapping("/Aboutus")
public String Aboutus()
{
	return "Aboutus";
}
//@RequestMapping("/cwaboutus")
//public String cwaboutus()
//{
//	return "cwaboutus";
//}
@RequestMapping("/dispcategory/{catId}")
public ModelAndView dispcategory(@ModelAttribute("product")Product pro,@PathVariable("catId") String id)
{
	ModelAndView obj=new ModelAndView("MensWear");
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	List<Product> lc=productDao.getProductByCategory(id);
	obj.addObject("products",lc);
	obj.addObject("product",pro);
	obj.addObject("cat",new Category());
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}
@RequestMapping("/Thankyou")
public ModelAndView Thankyou()
{
	ModelAndView obj=new ModelAndView("Thankyou");
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}

@RequestMapping("/About")
public ModelAndView About()
{
	ModelAndView obj=new ModelAndView("About");
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}
@RequestMapping("/Contact")
public ModelAndView Contact()
{
	ModelAndView obj=new ModelAndView("Contact");
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}
@RequestMapping("/MensWear")
public ModelAndView MensWear()
{
	ModelAndView obj=new ModelAndView("MensWear");
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}
@RequestMapping("/WomensWear")
public ModelAndView WomensWear()
{
	ModelAndView obj=new ModelAndView("WomensWear");
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}
@RequestMapping("/KidsWear")
public ModelAndView KidsWear()
{
	ModelAndView obj=new ModelAndView("KidsWear");
	List<Category> categories= categoryDao.list();
	List<Product> lproducts=productDao.list();
	obj.addObject("products", lproducts);
	obj.addObject("lcat",categories);
	return obj;
}
}
