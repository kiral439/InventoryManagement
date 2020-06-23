package org.dao.impl;
import org.dao1.LoginDao;
import org.dao1.RegisterDao;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import org.model.*;

public class RegisterDaoImp implements RegisterDao {
	
	private Register register;
	
	public Register validate(String username) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			
			Query query=Hsession.createQuery("from Login where username=?0");
			query.setParameter(0, username);
			query.setMaxResults(1);
			Register register=(Register)query.uniqueResult();		
			ts.commit();
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

}