package org.dao.impl;
import java.util.*;
import org.dao1.CourseDao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Course;
public class CourseDaoImp implements CourseDao{
	
	public Course getOneCourse(String cid) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from Course where cid=?0");
			query.setParameter(0, cid);
			query.setMaxResults(1);
			
			Course course=(Course) query.uniqueResult();
			
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
			List list=Hsession.createQuery("from Course order by cid").list();	
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
