package com.sec.entity;

import java.sql.Date;


public class Complainant {
	private int Complainant_ID;
	public int getComplainant_ID() {
		return Complainant_ID;
	}
	public void setComplainant_ID(int complainant_ID) {
		Complainant_ID = complainant_ID;
	}
	public String getComplainant_Content() {
		return Complainant_Content;
	}
	public void setComplainant_Content(String complainant_Content) {
		Complainant_Content = complainant_Content;
	}
	public String getComplainant_Type() {
		return Complainant_Type;
	}
	public void setComplainant_Type(String complainant_Type) {
		Complainant_Type = complainant_Type;
	}
	
	public int getWineshop_ID() {
		return Wineshop_ID;
	}
	public void setWineshop_ID(int wineshop_ID) {
		Wineshop_ID = wineshop_ID;
	}
	private String Complainant_Content;
	private String Complainant_Type;
	private String Complainant_Time;
	public String getComplainant_Time() {
		return Complainant_Time;
	}
	public void setComplainant_Time(String complainant_Time) {
		Complainant_Time = complainant_Time;
	}
	private int Wineshop_ID;
	

}
