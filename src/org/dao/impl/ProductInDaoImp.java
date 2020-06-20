package org.dao.impl;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.ProductIn;
import org.dao1.ProductInDao;

public class ProductInDaoImp implements ProductInDao{
	public ProductIn getOneProductIn(Integer id) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from ProductIn where id=?0");
			query.setParameter(0, id);
			query.setMaxResults(1);
			ProductIn productIn=(ProductIn) query.uniqueResult();		
			ts.commit();
			Hsession.clear();					
			return productIn;
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
			//List list=Hsession.createQuery("from ProductIn where status='On shipping'").list();	
			List list=Hsession.createQuery("from ProductIn").list();	
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public void update(ProductIn productIn) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Hsession.update(productIn);					
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
