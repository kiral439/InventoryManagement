package org.dao1;
import org.model.Student;
public interface StudentDao {
	
	public Student getOneStudent(String sID);
	
	public void update(Student student);
}
