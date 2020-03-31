package com.sec.entity;

public class TS {
	private int TouSu_ID;
	private String Wineshop_Name;
	private String TouSu_Type;
	private String TouSu_Text;
	private String TouSu_Time;
	private String FanKui_Text;
	public int getTouSu_ID() {
		return TouSu_ID;
	}
	public void setTouSu_ID(int touSu_ID) {
		TouSu_ID = touSu_ID;
	}
	@Override
	public String toString() {
		return "TS [TouSu_ID=" + TouSu_ID + ", Wineshop_Name=" + Wineshop_Name + ", TouSu_Type=" + TouSu_Type
				+ ", TouSu_Text=" + TouSu_Text + ", TouSu_Time=" + TouSu_Time + ", FanKui_Text=" + FanKui_Text + "]";
	}
	public String getWineshop_Name() {
		return Wineshop_Name;
	}
	public void setWineshop_Name(String wineshop_Name) {
		Wineshop_Name = wineshop_Name;
	}
	public String getTouSu_Type() {
		return TouSu_Type;
	}
	public void setTouSu_Type(String touSu_Type) {
		TouSu_Type = touSu_Type;
	}
	public String getTouSu_Text() {
		return TouSu_Text;
	}
	public void setTouSu_Text(String touSu_Text) {
		TouSu_Text = touSu_Text;
	}
	public String getTouSu_Time() {
		return TouSu_Time;
	}
	public void setTouSu_Time(String touSu_Time) {
		TouSu_Time = touSu_Time;
	}
	public String getFanKui_Text() {
		return FanKui_Text;
	}
	public void setFanKui_Text(String fanKui_Text) {
		FanKui_Text = fanKui_Text;
	}
	

}
