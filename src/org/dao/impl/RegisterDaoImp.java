package org.dao.impl;

import java.util.List;

import org.dao1.RegisterDao;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import org.model.Category;
import org.model.Login;
import org.model.Register;

public class RegisterDaoImp implements RegisterDao {
	@Override
	
  public Register validate(String username) { 
		try{ 
			Configuration cfg = new	Configuration().configure("hibernate.cfg.xml"); SessionFactory
				sessionFactory= cfg.buildSessionFactory(); Session
				Hsession=sessionFactory.openSession(); Transaction
				ts=Hsession.beginTransaction();
  
				Query query=Hsession.createQuery("from Register where username=?0");
				query.setParameter(0, username); 
				/* query.setParameter(1, password); */
  
  
				query.setMaxResults(1); 
				Register register=(Register)query.uniqueResult();
  
				ts.commit(); 
				Hsession.clear(); 
				Hsession.close();
  
				if(register!=null){ 
					return register; 
				}else{ 
					return null; 
				} 
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
			
			List list=Hsession.createQuery("from Register").list();		
			
			ts.commit();
			Hsession.clear();
			Hsession.close();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public String save(Register register) {
		Register reg = check(register);
		if (register == null) {
			try {
				Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
				SessionFactory sessionFactory = cfg.buildSessionFactory();
				Session Hsession = sessionFactory.openSession();
				Transaction ts = Hsession.beginTransaction();

				/*
				 * Query
				 * query=Hsession.createQuery("INSERT INTO accounts(username, stock_name) ");
				 * query.setParameter(0, username);
				 *
				 * query.setMaxResults(1); Register register=(Register)query.uniqueResult();
				 */

				Hsession.save(register);

				ts.commit();
				Hsession.clear();
				Hsession.close();
				System.out.println("User has been registered");
				return "Success";
			} catch (Exception e) {
				e.printStackTrace();
				return "Failed";
			}
		} else {
			System.out.println("username already exists");
			return "Failed";
		}
	}

	public Register check(Register register) {
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			Session Hsession = sessionFactory.openSession();
			Transaction ts = Hsession.beginTransaction();
			Query query = Hsession.createQuery("from Register where username=?0");
			query.setParameter(0, register.getUsername());

			query.setMaxResults(1);
			Register reg = (Register) query.uniqueResult();
			ts.commit();
			Hsession.clear();
			Hsession.close();
			return reg;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


