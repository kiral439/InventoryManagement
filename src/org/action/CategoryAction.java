package org.action;

import java.util.*;
import org.dao1.CategoryDao;
import org.dao.impl.CategoryDaoImp;
import org.model.Category;
import com.opensymphony.xwork2.*;

public class CategoryAction extends ActionSupport{
	private Category category;
	
	public String execute() throws Exception {
		CategoryDao categoryDao=new CategoryDaoImp();				
		List categories=categoryDao.getAll();
//		System.out.println(category);
		if(categories!=null){					
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("categories", categories);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}
