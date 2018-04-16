package com.niit.FashionWearFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Dao.UserDao;
import com.niit.FashionWear.Model.Billing;
import com.niit.FashionWear.Model.Cart;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.User;

@Controller
public class UserController {

@Autowired
User user;
@Autowired
UserDao userDao;
@Autowired
Billing billing;
@Autowired
CategoryDao categoryDao;



@RequestMapping("/user")
public ModelAndView user()
{
ModelAndView obj=new ModelAndView("User");
user.setBilling(billing);
obj.addObject("user",new User());
List<User> li=userDao.list();
obj.addObject("users",li);
List<Category> categories=categoryDao.list();
obj.addObject("lcat",categories);
return obj;
}



@RequestMapping("/adduser")
public ModelAndView adduser(@ModelAttribute("user")User user)
{
	ModelAndView obj=new ModelAndView("redirect:/user");
	Cart cart=new Cart();
	user.setCart(cart);
	Billing bill= new Billing();
	user.setBilling(bill);
	System.out.println(cart.getCart_Id());
	if(userDao.saveorupdate(user)==true)
	{
		obj.addObject("msg1","User added successfully");
		
	}
	else
	{
		obj.addObject("msg2","user not added");
		
	}
	return obj;
	
}

}










