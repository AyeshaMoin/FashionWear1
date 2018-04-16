package com.niit.FashionWear.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Dao.CategoryDao;
import com.niit.FashionWear.Dao.ShippingDao;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Shipping;
@Repository("shippingDao")
@EnableTransactionManagement
@Transactional


public class ShippingDaoImpl implements ShippingDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean saveorupdate(Shipping ship) {
		sessionFactory.getCurrentSession().saveOrUpdate(ship);
		
		return true;
		
	}
	@Override
   public boolean delete(Shipping ship) {
	   sessionFactory.getCurrentSession().delete(ship);
	   return true;
   }
	@Override
   public Shipping get(String shipId) {
	   String s1="From Shipping where Shipping_Id='"+shipId+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(s1);
	   List<Shipping> list=(List<Shipping>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
	@Override
       public List<Shipping> list(){
	   List<Shipping> shipping=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return shipping;
       }
	@Override
	public List<Shipping> getaddbyUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Shipping> getaddbyUser() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
