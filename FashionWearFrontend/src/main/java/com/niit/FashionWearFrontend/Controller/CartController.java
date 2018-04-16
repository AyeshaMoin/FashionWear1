package com.niit.FashionWearFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.FashionWear.Dao.CartDao;
import com.niit.FashionWear.Dao.CartItemsDao;
import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Dao.ProductDao;
import com.niit.FashionWear.Dao.UserDao;
import com.niit.FashionWear.Model.Cart;
import com.niit.FashionWear.Model.CartItems;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Product;
import com.niit.FashionWear.Model.User;

@Controller
public class CartController
{
	
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired
User user;
@Autowired
UserDao userDao;
@Autowired
Cart cart;
@Autowired
CartDao cartDao;
@Autowired
CartItems cartItems;
@Autowired
CartItemsDao cartItemsDao;
@Autowired
HttpSession session;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;

 @RequestMapping("/addtocart/{proId}")
 public ModelAndView cart(@PathVariable("proId") String id)
 {
	   Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	   if(!(authentication instanceof AnonymousAuthenticationToken))
	 {
		 
		   String currusername=authentication.getName();
		   User user =userDao.getUseremail(currusername);
		 if(user==null)
		 {
			 return new ModelAndView("redirect:/");
			 
		 }
		 else
		 {
		  	 cart =user.getCart();
			 Product product1=productDao.get(id);
			 CartItems cartItem =new CartItems();
			 cartItem.setCart(cart);
			 cartItem.setProduct(product1);
			 cartItem.setPrice(product1.getPrice());
	  		 cartItemsDao.saveorupdate(cartItem);
			 cart.setGrand_Total(cart.getGrand_Total()+product1.getPrice());
			 cart.setTotal_Items(cart.getTotal_Items()+1);
			 cartDao.saveorupdate(cart);
			 session.setAttribute("items",cart.getTotal_Items());
			 session.setAttribute("gd",cart.getGrand_Total());
			 return new ModelAndView("redirect:/");
			 
		 }
	 }
	 else
	 {
		return new ModelAndView("redirect:/");
	 }
	 }
 
	 @RequestMapping(value="/viewcart")
	 public String viewcart(Model model,HttpSession session)
	 {
		 Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		   if(!(authentication instanceof AnonymousAuthenticationToken))
		 {
			 
			   String currusername=authentication.getName();
			 User user =userDao.getUseremail(currusername);
			 Cart c=user.getCart();
			 List<CartItems> cartItems=cartItemsDao.getlist(user.getCart().getCart_Id());
			 if(cartItems==null)
			 {
				 session.setAttribute("items",0);
				 model.addAttribute("gtotal",0.0);
				 model.addAttribute("msg","no Items is added to cart");
				 return "Home";
			 }
			 model.addAttribute("cartItem",cartItems);
			 model.addAttribute("gtotal",c.getGrand_Total());
			 session.setAttribute("items",c.getTotal_Items());
			 session.setAttribute("items",c.getTotal_Items());
			 session.setAttribute("cartId",c.getCart_Id());
			 List<Category> categories= categoryDao.list();
			 model.addAttribute("lcat", categories);
			 return "viewcart";
			 }
		 else
		 {
		 return "redirect:/viewcart";
		 		 }
	 }
	 @RequestMapping(value="/Remove/{Cartitem_Id}")
	 public ModelAndView RemoveFromcart(@PathVariable("Cartitem_Id") String id)
	 {
		ModelAndView obj=new ModelAndView("redirect:/viewcart");
		cartItems =cartItemsDao.get(id);
		Cart c=cartItems.getCart();
	  	c.setGrand_Total(c.getGrand_Total()-cartItems.getPrice());
		c.setTotal_Items(c.getTotal_Items()-1);
		cartDao.saveorupdate(c);
		
		cartItemsDao.delete(cartItems);
		return obj;
	 }
 @RequestMapping(value="/Removeall")
public String RemoveallFromCart(Model model,HttpSession session)
{
	   Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

	  if(!(authentication instanceof AnonymousAuthenticationToken))
	 {
					
		             String currusername=authentication.getName();
		  			 User user =userDao.getUseremail(currusername);	
				  	 Cart c=cartDao.get(user.getCart().getCart_Id());
			  		 List<CartItems> cartItems=cartItemsDao.getlist(user.getCart().getCart_Id());
  					
			  		for(CartItems g:cartItems)
					 {
		  				 cartItemsDao.delete(g);
					 }
			  		c.setGrand_Total(0.0);
			  		c.setTotal_Items(0);
			  		cartDao.saveorupdate(c);
			  		session.setAttribute("items",c.getTotal_Items());
					return "redirect:/viewcart";
					 }
			  	 else
		  		 {
			  		 return "redirect:/";
					 
				 }
			 }
 }
	 
					 

