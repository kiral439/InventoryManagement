package org.dao.impl;
import java.util.*;
import org.dao1.CategoryDao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Category;
import org.model.Product;
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
			Hsession.clear();
			Hsession.close();
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
			Hsession.clear();
			Hsession.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Category validate(String name, String code) {
		return null;
	}
	
	public String save(Category category) {
		Category cat=check(category);
		if(cat==null) {
			try{
				Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		        SessionFactory sessionFactory= cfg.buildSessionFactory();
		        Session Hsession=sessionFactory.openSession();
				Transaction ts=Hsession.beginTransaction();
				Hsession.save(category);					
				ts.commit();
				Hsession.clear();
				Hsession.close();
				System.out.println("Category has been added");
				return "Success";
			}catch(Exception e){
				e.printStackTrace();
				return "Failed";
			}
		}else {
			System.out.println("Category already exists");
			return "Failed";
		}
		
		
	}
	
	public Category check(Category category) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from Category where code=?0 or name=?1");	
			query.setParameter(0, category.getCode());
			query.setParameter(1, category.getName());
			query.setMaxResults(1);
			Category cat=(Category) query.uniqueResult();
			ts.commit();
			Hsession.clear();
			Hsession.close();
			return cat;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
