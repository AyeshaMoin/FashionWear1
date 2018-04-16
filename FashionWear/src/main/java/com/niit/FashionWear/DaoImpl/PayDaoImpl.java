package com.niit.FashionWear.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Dao.PayDao;
import com.niit.FashionWear.Model.Pay;

@Repository("payDao")
@EnableTransactionManagement
@Transactional


public class PayDaoImpl implements PayDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public PayDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		
		return true;
		
	}
   public boolean delete(Pay pay) {
	   sessionFactory.getCurrentSession().delete(pay);
	   return true;
   }
   public Pay get(String payid) {
	   String pay1="From Category where Pay_Id='"+payid+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(pay1);
	   List<Pay> list=(List<Pay>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
       public List<Pay> list(){
	   List<Pay> pay=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return pay;
       }
}

