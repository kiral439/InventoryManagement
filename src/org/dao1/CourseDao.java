package org.dao1;
import java.util.*;
import org.model.Course;

public interface CourseDao {
	
	public Course getOneCourse(String cID);
	
	public List getAll();
}
