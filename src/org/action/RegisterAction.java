package org.action;
import java.util.List;
import java.util.Map;

import org.dao1.CategoryDao;
/*import org.dao1.ProductDao;*/
import org.dao1.RegisterDao;
import org.dao.impl.CategoryDaoImp;
/*import org.dao.impl.ProductDaoImp;*/
import org.dao.impl.RegisterDaoImp;
import org.model.Category;
import org.model.Register;
import com.opensymphony.xwork2.*;

public class RegisterAction extends ActionSupport{
	private Register register;
	RegisterDao registerDao;
	private Register registerBean;
	/* private ProductAction productAction = new ProductAction(); */

	public Register getRegisterBean() {
		return register;
	}

	public void setRegisterBean(Register registerBean) {
		this.registerBean = registerBean;
	}
	
	public String execute() throws Exception {
		
		RegisterDao registerDao=new RegisterDaoImp();				
		List registers=registerDao.getAll();
		
		if(registers!=null){					
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("registers", registers);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	public String getCategories() throws Exception {
		RegisterDao registerDao=new RegisterDaoImp();				
		List registers=registerDao.getAll();
		if(registers!=null){					
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("registers", registers);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	public String addCategory() throws Exception{
		boolean valid = false;
		registerDao = new RegisterDaoImp();
		Category category = new Category();
		try{
			category.setCode(registerBean.getUsername());
			category.setName(registerBean.getPassword());
			if(registerDao.save(register).equals("Success")) {
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
