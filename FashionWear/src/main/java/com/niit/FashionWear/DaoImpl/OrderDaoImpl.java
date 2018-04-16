package com.niit.FashionWear.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Dao.OrderDao;
import com.niit.FashionWear.Model.Order;


@Repository("orderDao")
@EnableTransactionManagement
@Transactional


public class OrderDaoImpl implements OrderDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean saveorupdate(Order ord) {
		sessionFactory.getCurrentSession().saveOrUpdate(ord);
		
		return true;
		
	}
	@Override
   public boolean delete(Order ord) {
	   sessionFactory.getCurrentSession().delete(ord);
	   return true;
   }
	@Override
   public Order get(String ordId) {
	   String c1="From Order where Order_Id='"+ordId+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(c1);
	   List<Order> list=(List<Order>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
	@Override
       public List<Order> list(){
	   List<Order> order=(List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return order;
       }
}

