package org.model;
import java.util.*;

public class Course{
	private String cid;
	private String name;
	private Integer semester;
	private Integer stu_num;
	private Integer credit;
	private Set student_set = new HashSet();
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSemester() {
		return semester;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public Integer getStu_num() {
		return stu_num;
	}
	public void setStu_num(Integer stu_num) {
		this.stu_num = stu_num;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Set getStudent_set() {
		return student_set;
	}
	public void setStudent_set(Set student_set) {
		this.student_set = student_set;
	}
}