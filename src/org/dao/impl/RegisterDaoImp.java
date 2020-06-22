package org.dao.impl;
import org.dao1.LoginDao;
import org.dao1.RegisterDao;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import org.model.Login;
import org.model.Register;

public class RegisterDaoImp implements RegisterDao {
	
	public Login validate(String username) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			
			Query query=Hsession.createQuery("from Login where username=?0");
			query.setParameter(0, username);
			query.setMaxResults(1);
			Login login=(Login)query.uniqueResult();		
			ts.commit();
			if(login!=null){					
				return login;
			}else{						
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}