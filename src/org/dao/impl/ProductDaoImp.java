package org.dao.impl;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Login;
import org.model.Product;
import org.dao1.ProductDao;

public class ProductDaoImp implements ProductDao{
	
//	public Login validate(int id) {
//		try{
//			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//	        SessionFactory sessionFactory= cfg.buildSessionFactory();
//	        Session Hsession=sessionFactory.openSession();
//			Transaction ts=Hsession.beginTransaction();
//			
//			Query query=Hsession.createQuery("from prod_list where id=?0");
//			query.setParameter(0, id);
//			query.setMaxResults(1);
//			Login login=(Login)query.uniqueResult();		
//			ts.commit();
//			if(login!=null){					
//				return login;
//			}else{						
//				return null;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}
//	}
	
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
			//Hsession.clear();
			if(product!=null){	
				System.out.println(product.getProd_id()+" "+product.getId()+" "+product.getIn_stock()+" " +product.getPending_stock());
				return product;
			}else{						
				return null;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Product getOneProduct(String prod_id) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from Product where prod_id=?0");
			query.setParameter(0, prod_id);
			query.setMaxResults(1);
			Product course=(Product) query.uniqueResult();		
			ts.commit();
			Hsession.clear();					
			return course;
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
	
	public void save(Product product) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Hsession.save(product);					
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
