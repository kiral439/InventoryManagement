package org.dao.impl;
import java.util.*;
import org.dao1.CategoryDao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Category;
public class CategoryDaoImp implements CategoryDao{

	public Category getOneCategory(Integer id) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from Category where id=?0");
			query.setParameter(0, id);
			query.setMaxResults(1);
			Category category=(Category) query.uniqueResult();				
			ts.commit();
			return category;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public List getAll() {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			List list=Hsession.createQuery("from Category").list();		
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
