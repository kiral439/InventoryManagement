package org.action;
import java.io.FileInputStream;
import java.util.*;
import java.util.Map;

import org.dao1.CategoryDao;
import org.dao1.CategoryDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.dao.impl.CategoryDaoImp;
import org.dao.impl.CategoryDaoImp;
import org.model.Category;
import org.model.Category;
import org.action.*;

import com.opensymphony.xwork2.*;
public class CategoryAction extends ActionSupport{
	
	private Category category;
	CategoryDao categoryDao;
	private Category categoryBean;
	
	
	public Category getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(Category categoryBean) {
		this.categoryBean = categoryBean;
	}

	public String execute() throws Exception {
		CategoryDao categoryDao=new CategoryDaoImp();				
		List categories=categoryDao.getAll();
		if(categories!=null){					
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("categories", categories);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	public String getCategories() throws Exception {
		CategoryDao categoryDao=new CategoryDaoImp();				
		List categories=categoryDao.getAll();
		if(categories!=null){					
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("categories", categories);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	public String addCategory() throws Exception{
		boolean valid = false;
		categoryDao = new CategoryDaoImp();
		Category category = new Category();
		try{
			category.setCode(categoryBean.getCode());
			category.setName(categoryBean.getName());
			if(categoryDao.save(category).equals("Success")) {
				valid = true;
			}
		}catch(Exception e){
			e.printStackTrace();		
		}
		if(valid){
			return this.getCategories();
		}
		else{
			return ERROR;
		}
	}
}
