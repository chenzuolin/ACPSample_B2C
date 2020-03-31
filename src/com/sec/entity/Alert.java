package com.sec.entity;

public class Alert {
	private int alertId;
	private String userName;
	private int alertPath;
	private String path;
	public int getAlertId() {
		return alertId;
	}
	public void setAlertId(int alertId) {
		this.alertId = alertId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAlertPath() {
		return alertPath;
	}
	public void setAlertPath(int alertPath) {
		this.alertPath = alertPath;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
