package com.niit.FashionWear.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Dao.BillingDao;
import com.niit.FashionWear.Model.Billing;



@Repository("billingDao")
@EnableTransactionManagement
@Transactional


public class BillingDaoImpl implements BillingDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public BillingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(Billing bil) {
		sessionFactory.getCurrentSession().saveOrUpdate(bil);
		
		return true;
		
	}
   public boolean delete(Billing bil) {
	   sessionFactory.getCurrentSession().delete(bil);
	   return true;
   }
   public Billing get(String UserId) {
	   String b1="From Billing where UserId='"+UserId+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(b1);
	   List<Billing> list=(List<Billing>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
       public List<Billing> list(){
	   List<Billing> billing=(List<Billing>) sessionFactory.getCurrentSession().createCriteria(Billing.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return billing;
       }
}

