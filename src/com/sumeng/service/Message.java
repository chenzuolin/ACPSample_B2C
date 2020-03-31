package com.sumeng.service;

public class Message {
	private int Consult_ID;
	private String Consult_Time;
	private String Content;
	private String User_Name;
	public int getConsult_ID() {
		return Consult_ID;
	}
	public void setConsult_ID(int consult_ID) {
		Consult_ID = consult_ID;
	}
	public String getConsult_Time() {
		return Consult_Time;
	}
	public void setConsult_Time(String consult_Time) {
		Consult_Time = consult_Time;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	@Override
	public String toString() {
		return "Message [Consult_ID=" + Consult_ID + ", Consult_Time="
				+ Consult_Time + ", Content=" + Content + ", User_Name="
				+ User_Name + "]";
	}

}
