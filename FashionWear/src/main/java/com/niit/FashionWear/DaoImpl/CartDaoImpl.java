package com.niit.FashionWear.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Dao.CartDao;
import com.niit.FashionWear.Model.Cart;


@Repository("cartDao")
@EnableTransactionManagement
@Transactional


public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean saveorupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
		return true;
		
	}
	@Override
   public boolean delete(Cart cart) {
	   sessionFactory.getCurrentSession().delete(cart);
	   return true;
   }
	@Override
   public Cart get(String cartid) {
	   String c1="From Cart where Cart_Id='"+cartid+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	   List<Cart> list=(List<Cart>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
	@Override
       public List<Cart> list(){
	   List<Cart> cart=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return cart;
       }
	
}
