package com.sec.entity;

public class Consult {

	private int Consult_ID;
	private int User_ID;
	private String Content;
	private String Consult_Time;
	public String getConsult_Time() {
		return Consult_Time;
	}
	public void setConsult_Time(String consult_Time) {
		Consult_Time = consult_Time;
	}
	public int getConsult_ID() {
		return Consult_ID;
	}
	public void setConsult_ID(int consult_ID) {
		Consult_ID = consult_ID;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
