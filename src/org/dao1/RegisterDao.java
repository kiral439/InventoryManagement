package org.dao1;
import java.util.List;

import org.model.Register;
public interface RegisterDao {
	
	public Register validate(String username);

	public String save(Register register);
	
	public List getAll();
}
