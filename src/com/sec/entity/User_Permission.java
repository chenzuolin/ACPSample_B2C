package com.sec.entity;

public class User_Permission {
	private int User_Permission_ID;
	public int getUser_Permission_ID() {
		return User_Permission_ID;
	}
	public void setUser_Permission_ID(int user_Permission_ID) {
		User_Permission_ID = user_Permission_ID;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public int getPermission_ID() {
		return Permission_ID;
	}
	public void setPermission_ID(int permission_ID) {
		Permission_ID = permission_ID;
	}
	private int User_ID;
	private int Permission_ID;

}
