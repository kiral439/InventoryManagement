package org.dao.impl;
import org.dao1.LoginDao;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import org.model.Login;
public class LoginDaoImp implements LoginDao {
	
	public Login validate(String username, String password) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			
			Query query=Hsession.createQuery("from Login where username=?0 and password=?1");
			query.setParameter(0, username);
			query.setParameter(1, password);
			query.setMaxResults(1);
			Login login=(Login)query.uniqueResult();		
			ts.commit();
			Hsession.clear();
			Hsession.close();
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