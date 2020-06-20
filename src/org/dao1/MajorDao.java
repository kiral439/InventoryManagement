package org.dao1;
import java.util.*;
import org.model.Major;
public interface MajorDao {
	
	public Major getOneMajor(Integer mID);
	
	public List getAll();
}
