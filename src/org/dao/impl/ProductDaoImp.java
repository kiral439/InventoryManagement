package org.dao.impl;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Product;
import org.dao1.ProductDao;

public class ProductDaoImp implements ProductDao{
	public Product getOneProduct(Integer id) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from Product where id=?0");
			query.setParameter(0, id);
			query.setMaxResults(1);
			Product product=(Product) query.uniqueResult();		
			ts.commit();
			Hsession.clear();					
			return product;
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
			List list=Hsession.createQuery("from Product order by prod_id").list();	
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
