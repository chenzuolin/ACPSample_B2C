package com.sec.entity;

import java.io.Serializable;
import java.sql.*;


public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int User_ID;
	private String User_Name;
	private String User_Password;
	private int Role_ID;
	private int Department_ID;
	private int sex;
	private String birthday;
	private String profile;
	private String User_Date;
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	
	public int getRole_ID() {
		return Role_ID;
	}
	public void setRole_ID(int role_ID) {
		Role_ID = role_ID;
	}
	
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	
	
	
		public int getDepartment_ID() {
		return Department_ID;
	}
	public void setDepartment_ID(int department_ID) {
		Department_ID = department_ID;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getUser_Date() {
		return User_Date;
	}
	public void setUser_Date(String user_Date) {
		User_Date = user_Date;
	}
		
}