package com.niit.FashionWear.DaoImpl;

import java.util.List;





import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Dao.CartItemsDao;
import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Model.Cart;
import com.niit.FashionWear.Model.CartItems;
import com.niit.FashionWear.Model.Category;
@Repository("cartItemsDao")
@EnableTransactionManagement
@Transactional


public class CartItemsDaoImpl implements CartItemsDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(CartItems cartitems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
		
		return true;
		
	}
   public boolean delete(CartItems cartitems) {
	   sessionFactory.getCurrentSession().delete(cartitems);
	   return true;
   }
   public CartItems get(String Cartitems_Id) {
	   String cartitems1="from CartItems where Cartitems_Id='"+Cartitems_Id+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(cartitems1);
	   List<CartItems> list=(List<CartItems>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
       public List<CartItems> list() {
	   List<CartItems> cartitems=(List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItemsDaoImpl.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return cartitems;
       }
	
	@Override
	public List<CartItems> getlist(String cart_Id) {
		 String cartitems1="from CartItems where cart_Id='"+cart_Id+"'";
		   Query q1=sessionFactory.getCurrentSession().createQuery(cartitems1);
		   List<CartItems> list=(List<CartItems>) q1.list();
		   if(list==null|| list.isEmpty())
		   {
			   return null;}
		   else {
			   return list;
		   }
	}
	@Override
	public CartItems getlistall(String cart_Id, String proId) {
		// TODO Auto-generated method stub
		return null;
	}
}
