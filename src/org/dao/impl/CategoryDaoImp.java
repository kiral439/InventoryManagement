package org.dao.impl;
import java.util.*;
import org.dao1.CategoryDao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.model.Category;
public class CategoryDaoImp implements CategoryDao{
	//查询某个专业的信息
	public Category getOneMajor(Integer id) {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			Query query=Hsession.createQuery("from Category where id=?0");
			query.setParameter(0, id);
			query.setMaxResults(1);
			Category category = (Category) query.uniqueResult();				//执行查询，返回结果
			ts.commit();
			return category;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//获取所有专业的信息
	public List getAll() {
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	        SessionFactory sessionFactory= cfg.buildSessionFactory();
	        Session Hsession=sessionFactory.openSession();
			Transaction ts=Hsession.beginTransaction();
			List list=Hsession.createQuery("from Category").list();		//获取结果集列表
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
