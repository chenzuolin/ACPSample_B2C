package com.sec.entity;

public class RolePower {
	private int Role_ID;
	private int id;
	private String menuName;
	private int status;
	public int getRole_ID() {
		return Role_ID;
	}
	public void setRole_ID(int role_ID) {
		Role_ID = role_ID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
