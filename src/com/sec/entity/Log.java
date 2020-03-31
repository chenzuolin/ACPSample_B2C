package com.sec.entity;

import java.io.Serializable;

public class Log implements Serializable{
	private String log_Id;
	private String log_Time;
	private String log_Name;
	private String log_Ip;
	private String log_Ip_Name;
	private String log_Type;
	public String getLog_Id() {
		return log_Id;
	}
	public void setLog_Id(String log_Id) {
		this.log_Id = log_Id;
	}
	public String getLog_Time() {
		return log_Time;
	}
	public void setLog_Time(String log_Time) {
		this.log_Time = log_Time;
	}
	public String getLog_Name() {
		return log_Name;
	}
	public void setLog_Name(String log_Name) {
		this.log_Name = log_Name;
	}
	public String getLog_Ip() {
		return log_Ip;
	}
	public void setLog_Ip(String log_Ip) {
		this.log_Ip = log_Ip;
	}
	public String getLog_Ip_Name() {
		return log_Ip_Name;
	}
	public void setLog_Ip_Name(String log_Ip_Name) {
		this.log_Ip_Name = log_Ip_Name;
	}
	public String getLog_Type() {
		return log_Type;
	}
	public void setLog_Type(String log_Type) {
		this.log_Type = log_Type;
	}
	public String getLog_Content() {
		return log_Content;
	}
	public void setLog_Content(String log_Content) {
		this.log_Content = log_Content;
	}
	private String log_Content;
}
