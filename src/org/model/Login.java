package org.model;
import java.util.*;
/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */
public class Login{
	//Fields
	private String username;
	private String password;
	private String acc_type;
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	
}
