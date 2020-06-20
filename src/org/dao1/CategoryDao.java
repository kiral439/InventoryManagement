package org.dao1;
import java.util.*;
import org.model.Category;
public interface CategoryDao {
	
	public Category getOneCategory(Integer ID);
	
	public List getAll();
}
