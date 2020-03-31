package com.sec.entity;

public class Department {
	private int Department_ID;
	public int getDepartment_ID() {
		return Department_ID;
	}
	public void setDepartment_ID(int department_ID) {
		Department_ID = department_ID;
	}
	public String getDepartment_Name() {
		return Department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}
	public String getDepartment_Remark() {
		return Department_Remark;
	}
	public void setDepartment_Remark(String department_Remark) {
		Department_Remark = department_Remark;
	}
	private String Department_Name;
	private String Department_Remark;

}
