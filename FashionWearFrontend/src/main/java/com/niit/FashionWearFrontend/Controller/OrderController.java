package com.niit.FashionWearFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.smartcardio.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.FashionWear.Dao.BillingDao;
import com.niit.FashionWear.Dao.CartDao;
import com.niit.FashionWear.Dao.CartItemsDao;
import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Dao.OrderDao;
import com.niit.FashionWear.Dao.OrderItemsDao;
import com.niit.FashionWear.Dao.PayDao;
import com.niit.FashionWear.Dao.ProductDao;
import com.niit.FashionWear.Dao.ShippingDao;
import com.niit.FashionWear.Dao.UserDao;
import com.niit.FashionWear.Model.Billing;
import com.niit.FashionWear.Model.Cart;
import com.niit.FashionWear.Model.CartItems;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Order;
import com.niit.FashionWear.Model.OrderItems;
import com.niit.FashionWear.Model.Pay;
import com.niit.FashionWear.Model.Product;
import com.niit.FashionWear.Model.Shipping;
import com.niit.FashionWear.Model.User;
import com.niit.FashionWear.OtpGenerator.OtpGenerator;

@Controller
public class OrderController {
@Autowired
Cart cart;
@Autowired
CartDao cartDao;
@Autowired
CartItems cartItems;
@Autowired
CartItemsDao cartItemsDao;
@Autowired
Billing billing;
@Autowired
BillingDao billingDao;
@Autowired
Shipping shipping;
@Autowired
ShippingDao shippingDao;
@Autowired
Pay pay;
@Autowired
PayDao payDao;
@Autowired
Order order;
@Autowired
OrderDao orderDao;
@Autowired
OrderItems orderItems;
@Autowired
OrderItemsDao orderItemsDao;
@Autowired
Product product;
@Autowired
ProductDao productDao;
@Autowired
User user;
@Autowired
UserDao userDao;
List<CartItems> cartItem1;
@Autowired
Category category;
@Autowired
CategoryDao categoryDao;

@Autowired
private JavaMailSender mailSender;
String o;

@RequestMapping("/Buyall")
public String orderall(Model model,HttpSession session)
{
   Authentication	authentication=SecurityContextHolder.getContext().getAuthentication();
   if(!(authentication instanceof AnonymousAuthenticationToken))
    {
    	 String currusername=authentication.getName();
		 User u =userDao.getUseremail(currusername);
		 cart=u.getCart();
		 product=null;
		 session.setAttribute("products",product);
//		 cartItems=cartItemsDao.get(cart.getCart_Id());
		 cartItem1=cartItemsDao.getlist(cart.getCart_Id());
		 if(cartItem1==null|| cartItem1.isEmpty())
		 {
             return "redirect:/viewcart";
		 }
		 else
		 {
			 billing=billingDao.get(u.getUserId());
			 List<Shipping> shipping=shippingDao.getaddbyUser(u.getUserId());
			 model.addAttribute("billing",billing);
			 model.addAttribute("user",user); 
			 model.addAttribute("shippings",shipping);
			 model.addAttribute("shipping",new Shipping());
			 model.addAttribute("prot",product);
			 session.setAttribute("prot",product);
        	 List<Category> categories=categoryDao.list();
		 model.addAttribute("lcat",categories);
		 }
    }
		
		 
    return "address";
}
    
    @RequestMapping("/Buy/{ProId}/{Cartitem_Id}")
    public String order(@PathVariable("ProId") String id,@PathVariable("Cartitem_Id") String id2,Model model,HttpSession session)
    {
       Authentication	authentication=SecurityContextHolder.getContext().getAuthentication();
       if(!(authentication instanceof AnonymousAuthenticationToken))
       {
        	 
   		 String currusername=authentication.getName();
    		 User u =userDao.getUseremail(currusername);
    		 cart=u.getCart();
             cartItem1=null;
             product=productDao.get(id);
             billing=billingDao.get(u.getUserId());
             cartItems=cartItemsDao.get(id2);
//           System.out.println(billing.getCountry());           
//           for(Billing b:billing)
// {
//		 System.out.println(b.getBill_Id());
//		 System.out.println(b.getCountry());
//		 }
         List<Shipping> shipping=shippingDao.getaddbyUser(u.getUserId());
		 user.setBilling(billing);
		 model.addAttribute("billing", billing);
		 model.addAttribute("user", user);
		 model.addAttribute("shippings", shipping);
		 model.addAttribute("shipping", new Shipping());
		 session.setAttribute("prot", product);
		 model.addAttribute("citem", cartItems);
		 List<Category> categories=categoryDao.list();
		 model.addAttribute("lcat", categories);
		 return "address";
    }
    else
   {
   	return "redirect:/";
    	
    }
    }

@RequestMapping("/orderConfirm")
public String payment(@ModelAttribute("shipping")Shipping sh,Model model)
{
//	if(cartItems==null  ||  cartItems.isEmpty())
//	{
//		System.out.println("sorry");
		
//	}
		sh.setUser(user);	
		shipping=sh;
		 model.addAttribute("billing", billing);
		 model.addAttribute("shippingAddress", shipping);
		 model.addAttribute("prot", product);
		 model.addAttribute("cartItem1", cartItem1);
		 model.addAttribute("cart",cart);
		 List<Category> categories=categoryDao.list();
		 model.addAttribute("lcat", categories);
		 return "orderconfirm";
		 
}

@RequestMapping("/previous")
public String previous(Model model)
{
	List<Shipping> shippings=shippingDao.getaddbyUser(user.getUserId());
		 model.addAttribute("shipping", shipping);
		 model.addAttribute("billing", billing);
		 model.addAttribute("shippings", shippings);
		 model.addAttribute("product",product);
		 model.addAttribute("user", user);
		 return "address";				 
}		
@RequestMapping("/pay")
public String pay(Model model)
{
//	List<Card> card=cardDao.getcardbyUser(userinfo.getUid());
//		model.addAttribute("cards", cards);
//		 model.addAttribute("cards", new card());	
		 List<Category> categories=categoryDao.list();
		 model.addAttribute("lcat", categories);
		 return "Payment";
}		 
@RequestMapping("/payment")
public String Payment(@RequestParam("otp") String otp,Model model)
			{
		int a;
		if(otp==null)
			a=2;
		else
			a=1;
		switch(a)
		{
		case 1:
			if(otp.equals(o))
			{
				pay.setPay_Method("COD");
				pay.setStatus("NO");
				break;
			}
			else
			{
			return "redirect:/orderconfirmation";
			}
		
		
	case 2:
		pay.setPay_Method("card");
		pay.setStatus("yes");
		payDao.saveorupdate(pay);
	//	cardDao.saveorupdate(cart);
		break;
		}
		 List<Category> categories=categoryDao.list();
		 model.addAttribute("lcat",categories);
		 return "redirect:/orderconfirmation";
		 }
		 

		@RequestMapping("/orderconfirmation")
		 public String orderconfirmation(HttpSession session)
		 {
			 System.out.println(32);
			 order.setBilling(billing);
			 order.setShipping(shipping);
			 order.setPay(pay);
			 order.setUser(user);
	//		 System.out.println(524);
			 if(cartItem1==null)
			 {
				 order.setGrand_Total(product.getPrice());
				 orderDao.saveorupdate(order);
				 orderItems.setOrder(order);
				 orderItems.setProduct_Id(product.getProId());
				 orderItemsDao.saveorupdate(orderItems);
				 System.out.println(cartItems.getPrice());
				 cart.setGrand_Total(cart.getGrand_Total()-cartItems.getPrice());
				 cart.setTotal_Items(cart.getTotal_Items()-1);
				 session.setAttribute("items",cart.getTotal_Items());
				 cartDao.saveorupdate(cart);
				 cartItemsDao.delete(cartItems);
					 //cartItemsDao.delete(cartItemsDao.getlistall(cart.getCart_Id(),product.getProId()));
				 System.out.println(324);
			 }
			 else
			 {
				 System.out.println(656);
				 order.setGrand_Total(cart.getGrand_Total());
				 orderDao.saveorupdate(order);
				 for(CartItems c: cartItem1)
				 {
					 System.out.println(3444);
					 orderItems.setOrder(order);
				//	 orderItems.setProduct_Id(c.getProduct().getProId());
					 System.out.println(3443);
					 orderItemsDao.saveorupdate(orderItems);
					 cartItemsDao.delete(c);
				 }
				 cart.setGrand_Total(0.0);
				 cart.setTotal_Items(0);
				 System.out.println(346);
				session.setAttribute("Items",cart.getTotal_Items()); 
				cartDao.saveorupdate(cart);
	}			 
	cartItems=null;
	cartItem1=null;
	product=null;
	order=new Order();
	orderItems=new OrderItems();
	 
	System.out.println(565);
	return "Thankyou";
		 }
		
		 @RequestMapping(value="/SendMail")
		 public void SendMail() {
	//		 System.out.println(21312);
			 Authentication	authentication=SecurityContextHolder.getContext().getAuthentication();
		        if(!(authentication instanceof AnonymousAuthenticationToken))
		        {
		        	String currusername=authentication.getName();
		   		 User user =userDao.getUseremail(currusername);
		   		 OtpGenerator ot=new OtpGenerator();
		//   		 String o=ot.Otpga();
		   		 o=ot.Otpga();
		   		 String recipientAddress=user.getEmail();
		   		 String subject="OTP";
//                 String subject = request.getParameter("subject");
                 String message="your one time password is "+o+" ";
              
              System.out.println("TO:" +recipientAddress);
             System.out.println("Subject:"+subject);
            System.out.println("Message:"+message);

   //        System.out.println("OTP:"+ot);
        SimpleMailMessage email = new SimpleMailMessage();
      email.setTo(recipientAddress);
      email.setSubject(subject);
      email.setText(message);
//     email.setSubject(o);
     mailSender.send(email);

       
       }
				 
			 }
			
}
