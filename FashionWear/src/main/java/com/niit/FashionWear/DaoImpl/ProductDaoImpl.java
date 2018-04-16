package com.niit.FashionWear.DaoImpl;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Model.Product;
import com.niit.FashionWear.Dao.ProductDao;
@Repository("productDao")
@EnableTransactionManagement
@Transactional

	public class ProductDaoImpl implements ProductDao {
		@Autowired
		SessionFactory sessionFactory;
		
		public ProductDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory=sessionFactory;
		}
		public boolean saveorupdate(Product pro) {
			sessionFactory.getCurrentSession().saveOrUpdate(pro);
			
			return true;
			
		}
	   public boolean delete(Product pro) {
		   sessionFactory.getCurrentSession().delete(pro);
		   return true;
	   }
	   public Product get(String proid) {
		   String p1="From Product where proId='"+proid+"'";
		   Query q1=sessionFactory.getCurrentSession().createQuery(p1);
		   List<Product> list=(List<Product>) q1.list();
		   if(list==null|| list.isEmpty())
		   {
			   return null;}
		   else {
			   return list.get(0);
		   }

		   }
	   public List<Product> getProductByCategory(String catId) {
		   String c1="From Product where catId='"+catId+"'";
		   Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		   List<Product> list=(List<Product>) q1.list();
		   if(list==null|| list.isEmpty())
		   {
			   return null;}
		   else {
			   return list;
		   }
	   }
	       public List<Product> list(){
		   List<Product> product=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class)
				   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return product;
	       }
		public List<Product>getProductBySupplier(String SupId) {
			return null;
		}
}
