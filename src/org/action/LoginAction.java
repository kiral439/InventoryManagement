package org.action;
import java.util.Map;
import org.dao1.LoginDao;
import org.dao.impl.LoginDaoImp;
import org.model.Login;
import com.opensymphony.xwork2.*;
public class LoginAction extends ActionSupport{
	
	private Login login;
	private ProductAction productAction = new ProductAction();
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login=login;
	}
	
	public String execute() throws Exception {
		LoginDao loginDao=new LoginDaoImp();				
		Login user=loginDao.validate(login.getUsername(), login.getPassword());
		if(user!=null){
			Map session=(Map)ActionContext.getContext().getSession();
			session.put("user", user);
			return productAction.getAllProduct();
		}
		else{
			
			return ERROR;
		}
	}
}
