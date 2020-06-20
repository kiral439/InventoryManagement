package org.model;
import java.util.*;
/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */
public class Student{
	//Fields
	private String sid;
	private String name;
	private Integer gender;
	private String birthday;
	private Integer credit;
	private String remarks;
	private byte[] photo;
	private Major major;						//‘ˆº” zyb  Ù–‘
	private Set course_set = new HashSet();	
	//Constructors
	/** default constructor */
	public Student() {
	}
	/** minimal constructor */
	public Student(String sid, String name, Integer gender) {
		this.sid = sid;
		this.name = name;
		this.gender = gender;
	}
	/** full constructor */
	public Student(String sid, String name, Integer gender, String birthday,
			Integer credit, String remarks, byte[] photo, Major major) {
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.credit = credit;
		this.remarks = remarks;
		this.photo = photo;
		this.major = major;
	}
	
	public String getSid() {
		return this.sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getGender() {
		return this.gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Integer getCredit() {
		return this.credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public byte[] getPhoto() {
		return this.photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Major getMajor(){
		return this.major;
	}	
	public void setMajor(Major major){
		this.major = major;
	}
	
	public Set getCourse_set(){
		return this.course_set;
	}	
	public void setCourse_set(Set course_set){
		this.course_set = course_set;
	}
}
