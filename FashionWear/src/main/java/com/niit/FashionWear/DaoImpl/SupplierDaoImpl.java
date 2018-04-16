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
import com.niit.FashionWear.Dao.SupplierDao;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.Supplier;
@Repository("supplierDao")
@EnableTransactionManagement
@Transactional


public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(Supplier sup) {
		sessionFactory.getCurrentSession().saveOrUpdate(sup);
		
		return true;
		
	}
   public boolean delete(Supplier sup) {
	   sessionFactory.getCurrentSession().delete(sup);
	   return true;
   }
   public Supplier get(String supid) {
	   String sup1="From Supplier where SupId='"+supid+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(sup1);
	   List<Supplier> list=(List<Supplier>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
       public List<Supplier> list(){
	   List<Supplier> supplier=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return supplier;
       }
}

