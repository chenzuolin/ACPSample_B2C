package com.sec.entity;

public class Permission {
	private int Permission_ID;
	public int getPermission_ID() {
		return Permission_ID;
	}
	public void setPermission_ID(int permission_ID) {
		Permission_ID = permission_ID;
	}
	public int getPermission_Func_No() {
		return Permission_Func_No;
	}
	public void setPermission_Func_No(int permission_Func_No) {
		Permission_Func_No = permission_Func_No;
	}
	public String getPermission_Remark() {
		return Permission_Remark;
	}
	public void setPermission_Remark(String permission_Remark) {
		Permission_Remark = permission_Remark;
	}
	private int Permission_Func_No;
	private String Permission_Remark;

}
