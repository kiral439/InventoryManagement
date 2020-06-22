package org.action;

import com.opensymphony.xwork2.ActionSupport;
import org.model.Login;

public class RegisterAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Login personBean;
	
	public String execute() throws Exception {
		
		//call Service class to store personBean's state in database
		return SUCCESS;
		
	}
	
	public void validate(){
		
		if ( personBean.getUsername().length() == 0 ){	

			addFieldError( "personBean.firstName", "First name is required." );
			
		}
		
				
		if ( personBean.getPassword().length() == 0 ){	

			addFieldError( "personBean.email", "Email is required." );
		}
	}
		
	public Login getPersonBean() {
		
		return personBean;
		
	}
	
	public void setPersonBean(Login person) {
		
		personBean = person;
		
	}

}