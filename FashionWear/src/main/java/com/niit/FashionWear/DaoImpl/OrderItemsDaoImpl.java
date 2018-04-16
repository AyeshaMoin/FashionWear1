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
import com.niit.FashionWear.Dao.OrderItemsDao;
import com.niit.FashionWear.Model.Category;
import com.niit.FashionWear.Model.OrderItems;
@Repository("orderItemsDao")
@EnableTransactionManagement
@Transactional


public class OrderItemsDaoImpl implements OrderItemsDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public boolean saveorupdate(OrderItems orderitems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderitems);
		
		return true;
		
	}
   public boolean delete(OrderItems orderitems) {
	   sessionFactory.getCurrentSession().delete(orderitems);
	   return true;
   }
   public OrderItems get(String orderitemsid) {
	   String orderitems1="From OrderItems where Orderitem_Id='"+orderitemsid+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(orderitems1);
	   List<OrderItems> list=(List<OrderItems>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
       public List<OrderItems> list() {
	List<OrderItems> orderitems=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return orderitems;
       }
}