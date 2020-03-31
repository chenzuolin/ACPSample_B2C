package com.sec.entity;

public class WCdemo {
	private String name;
	private String tel;
	private int id;
	private String time;
	private String ZT;
	public String getTel() {
		return tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getZT() {
		return ZT;
	}
	public void setZT(String zT) {
		ZT = zT;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
