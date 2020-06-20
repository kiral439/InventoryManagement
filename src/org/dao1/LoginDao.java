package org.dao1;
import org.model.Login;
public interface LoginDao {
	
	public Login validate(String username, String password);
}
