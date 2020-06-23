package org.action;

import java.util.Map;

import org.dao1.LoginDao;
import org.dao1.RegisterDao;
import org.dao.impl.LoginDaoImp;
import org.dao.impl.RegisterDaoImp;
import org.model.Login;
import org.model.Register;
import com.opensymphony.xwork2.*;

public class RegisterAction extends ActionSupport {
	
	private Register register;
	
	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String execute() throws Exception {
		
		RegisterDao registerDao = new RegisterDaoImp();				
		Register user = registerDao.validate(register.getUsername());
		if(user!=null){
			Map session=(Map)ActionContext.getContext().getSession();
			session.put("user", user);
			return SUCCESS;
		}
		else{
			
			return ERROR;
		}
		
	}
	
}

