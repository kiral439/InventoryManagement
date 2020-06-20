package org.action;
import java.io.*;
import java.util.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.dao1.*;
import org.dao.impl.*;
import org.model.*;
import com.opensymphony.xwork2.*;
public class StudentAction extends ActionSupport{
	StudentDao studentDao;
	private Student student;				
	private Course course;				
	private File photoFile;			
	private Major major;				

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public File getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public String execute() throws Exception {
		Map session=(Map)ActionContext.getContext().getSession();		
		Login user=(Login)session.get("user");						
		studentDao=new StudentDaoImp();						
		Student student=studentDao.getOneStudent(user.getUsername());		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("student", student);								
		return SUCCESS;
	}
	
	public String getImage() throws Exception{
		studentDao=new StudentDaoImp();
		byte[] photo=studentDao.getOneStudent(student.getSid()).getPhoto();	
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("image/jpeg");
		ServletOutputStream os=response.getOutputStream();		
		if(photo!=null&&photo.length>0){
			for(int i=0;i<photo.length;i++){
				os.write(photo[i]);
			}
		}
		return NONE;									
	}
	
	public String updateStudentInfo() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Login user=(Login)session.get("user");
		studentDao=new StudentDaoImp();
		MajorDao majorDao=new MajorDaoImp();
		
		List majors=majorDao.getAll();
		Student student=studentDao.getOneStudent(user.getUsername());	
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("majors", majors);
		request.put("student", student);
		return SUCCESS;
	}
	
	public String updateStudent() throws Exception{
		studentDao=new StudentDaoImp();
		MajorDao majorDao=new MajorDaoImp();
		Student stu=new Student();					
		stu.setSid(student.getSid());					
		stu.setName(student.getName());					
		stu.setGender(student.getGender());					
		stu.setBirthday(student.getBirthday());				
		stu.setCredit(student.getCredit());					
		stu.setRemarks(student.getRemarks());					
	
		if(this.getPhotoFile()!=null){
			FileInputStream fis=new FileInputStream(this.getPhotoFile());	
			byte[] buffer=new byte[fis.available()];	
			fis.read(buffer);					
			stu.setPhoto(buffer);
		}
		Major mj=majorDao.getOneMajor(major.getMid());
		
		stu.setMajor(mj);
		
		Set list=studentDao.getOneStudent(student.getSid()).getCourse_set();
		stu.setCourse_set(list);						
		studentDao.update(stu);				
		return SUCCESS;
	}
	
	public String getCourseList() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Login user=(Login)session.get("user");
		String sid=user.getUsername();
		Student student=new StudentDaoImp().getOneStudent(sid);			
		Set list=student.getCourse_set();								
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list",list);							
		return SUCCESS;
	}
	
	public String deleteCourse() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		String sid=((Login)session.get("user")).getUsername();
		studentDao=new StudentDaoImp();
		Student stu=studentDao.getOneStudent(sid);
		Set list=stu.getCourse_set();
		Iterator iter=list.iterator();
		while(iter.hasNext()){					
			Course cour=(Course)iter.next();
			if(cour.getCid().equals(course.getCid())){	
				iter.remove();
			}
		}
		stu.setCourse_set(list);						
		studentDao.update(stu);
		return SUCCESS;
	}
	
	public String selectCourse() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		String sid=((Login)session.get("user")).getUsername();
		studentDao=new StudentDaoImp();
		Student stu=studentDao.getOneStudent(sid);
		Set list=stu.getCourse_set();
		Iterator iter=list.iterator();
		
		while(iter.hasNext()){
			Course cour=(Course)iter.next();
			if(cour.getCid().equals(course.getCid())){
				return ERROR;
			}
		}
		list.add(new CourseDaoImp().getOneCourse(course.getCid()));		
		stu.setCourse_set(list);
		studentDao.update(stu);
		return SUCCESS;
	}
}