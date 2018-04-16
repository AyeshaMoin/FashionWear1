package com.niit.FashionWear.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Model.Authentication;
import com.niit.FashionWear.Model.Billing;
import com.niit.FashionWear.Model.User;
import com.niit.FashionWear.Dao.UserDao;

@Repository("userDao")
@EnableTransactionManagement
@Transactional


public  class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveorupdate(User user) {
		Authentication auth= new Authentication();
		Billing billing= new Billing();
		billing.setCountry(billing.getCountry());
		auth.setUsername(user.getEmail());
		auth.setRolename(user.getRole());
		user.getBilling().setUser(user);
		user.getBilling().setMobile_No(user.getMobile_No());
		user.getBilling().setEmail(user.getEmail());
		user.getBilling().setHouse_No(user.getHouse_No());
		user.getBilling().setCity(user.getCity());
		user.getBilling().setPincode(user.getPincode());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
		
		return true;
		
	}
   public boolean delete(User user) {
	   sessionFactory.getCurrentSession().delete(user);
	   return true;
   }
   public User get(String userId) {
	   String u1="From User where UserId='"+userId+"'";
	   Query q1=sessionFactory.getCurrentSession().createQuery(u1);
	   List<User> list=(List<User>) q1.list();
	   if(list==null|| list.isEmpty())
	   {
		   return null;}
	   else {
		   return list.get(0);
	   }

	   }
       public List<User> list(){
	   List<User> user=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
			   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return user;
       }
	@Override
	public User isValid(String umail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getUseremail(String currusername) {
		 String u1="From User where Email='"+currusername+"'";
		   Query q1=sessionFactory.getCurrentSession().createQuery(u1);
		   List<User> list=(List<User>) q1.list();
		   if(list==null|| list.isEmpty())
		   {
			   return null;}
		   else {
			   return list.get(0);
		   }
	}
}


