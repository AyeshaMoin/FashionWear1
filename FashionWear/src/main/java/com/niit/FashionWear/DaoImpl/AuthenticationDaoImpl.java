package com.niit.FashionWear.DaoImpl;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.FashionWear.Dao.AuthenticationDao;
import com.niit.FashionWear.Model.Authentication;
import com.niit.FashionWear.Model.Category;
	@Repository("authenticationDao")
	@EnableTransactionManagement
	@Transactional

	public class AuthenticationDaoImpl implements AuthenticationDao{
		@Autowired
		SessionFactory sessionFactory;
		
		public AuthenticationDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory=sessionFactory;
		}

		@Override
		public boolean saveorupdate(Authentication auth) {
			sessionFactory.getCurrentSession().saveOrUpdate(auth);
			
			return true;
		}

		@Override
		public boolean delete(Authentication auth) {
			sessionFactory.getCurrentSession().delete(auth);
			
			return true;
		}

		@Override
		public Authentication get(String role_id) {
			String c1="from Authentication where role_id='"+role_id+"'";
			Query q1=sessionFactory.getCurrentSession().createQuery(c1);
			List<Authentication> list=(List<Authentication>) q1.list();
			if(list==null|| list.isEmpty())
			{
			return null;}
			else {
				return list.get(0);
			}
		}

		@Override
		public List<Authentication> list() {
			List<Authentication> auth=(List<Authentication>)sessionFactory.getCurrentSession().createCriteria(Category.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return auth;
		}

}
