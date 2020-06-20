package org.action;
import java.util.Map;

import org.dao1.CategoryDao;
import org.dao1.LoginDao;
import org.dao.impl.CategoryDaoImp;
import org.dao.impl.LoginDaoImp;
import org.model.Category;
import org.model.Login;
import com.opensymphony.xwork2.*;
public class CategoryAction extends ActionSupport{
	
	private Category category;
	
	public Category getLogin() {
		return category;
	}
	
	public void setLogin(Category category) {
		this.category=category;
	}
	
	public String execute() throws Exception {
		CategoryDao categoryDao=new CategoryDaoImp();				
		Category cat=categoryDao.validate(category.getName(), category.getCode());
		if(cat!=null){
			Map session=(Map)ActionContext.getContext().getSession();
			//request.put("cat", cat);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}
