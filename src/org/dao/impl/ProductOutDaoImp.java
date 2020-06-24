package org.dao.impl;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.ProductOut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.opensymphony.xwork2.ActionContext;
import org.dao1.ProductOutDao;

public class ProductOutDaoImp implements ProductOutDao{
	public ProductOut getOneProductOut(Integer id) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from ProductOut where id=?0");
			query.setParameter(0, id);
			query.setMaxResults(1);
			ProductOut productOut=(ProductOut) query.uniqueResult();		
			ts.commit();
			Hsession.clear();
			Hsession.close();				
			return productOut;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ProductOut getOneProductOutByProd_id(String prod_id, Integer id) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from ProductOut prod_id=?0 and id=?1");
			query.setParameter(0, prod_id);
			query.setParameter(1, id);
			query.setMaxResults(1);
			ProductOut productOut=(ProductOut) query.uniqueResult();		
			ts.commit();
			Hsession.clear();
			Hsession.close();					
			return productOut;
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
			List list=Hsession.createQuery("from ProductOut").list();	
			ts.commit();
			Hsession.clear();
			Hsession.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List getOnShipping() {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			List list=Hsession.createQuery("from ProductOut where status='On shipping'").list();		
			ts.commit();
			Hsession.clear();
			Hsession.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
