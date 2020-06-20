package org.dao.impl;
import org.dao1.StudentDao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Student;
public class StudentDaoImp implements StudentDao{
	
	public Student getOneStudent(String sid) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			
			Query query=Hsession.createQuery("from Student where sid=?0");
			query.setParameter(0, sid);
			query.setMaxResults(1);
			Student student=(Student) query.uniqueResult();			
			ts.commit();
			Hsession.clear();
			return student;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//修改某个学生的个人信息
	public void update(Student student) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Hsession.update(student);					//执行修改操作
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
