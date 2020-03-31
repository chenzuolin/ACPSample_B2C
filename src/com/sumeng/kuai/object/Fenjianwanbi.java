package com.sumeng.kuai.object;

public class Fenjianwanbi {
	private int Courier_ID;
	private String Courier_Name;
	private int Wineshop_ID;
	private String Wineshop_Name;
	public int getCourier_ID() {
		return Courier_ID;
	}
	public void setCourier_ID(int courier_ID) {
		Courier_ID = courier_ID;
	}
	public String getCourier_Name() {
		return Courier_Name;
	}
	public void setCourier_Name(String courier_Name) {
		Courier_Name = courier_Name;
	}
	public int getWineshop_ID() {
		return Wineshop_ID;
	}
	public void setWineshop_ID(int wineshop_ID) {
		Wineshop_ID = wineshop_ID;
	}
	public String getWineshop_Name() {
		return Wineshop_Name;
	}
	public void setWineshop_Name(String wineshop_Name) {
		Wineshop_Name = wineshop_Name;
	}
	public String getWineshop_Address() {
		return Wineshop_Address;
	}
	public void setWineshop_Address(String wineshop_Address) {
		Wineshop_Address = wineshop_Address;
	}
	public String getWineshop_Time() {
		return Wineshop_Time;
	}
	public void setWineshop_Time(String wineshop_Time) {
		Wineshop_Time = wineshop_Time;
	}
	public String getWineshop_Shift_Name() {
		return Wineshop_Shift_Name;
	}
	public void setWineshop_Shift_Name(String wineshop_Shift_Name) {
		Wineshop_Shift_Name = wineshop_Shift_Name;
	}
	public String getWIneshop_Telephone() {
		return WIneshop_Telephone;
	}
	public void setWIneshop_Telephone(String wIneshop_Telephone) {
		WIneshop_Telephone = wIneshop_Telephone;
	}
	public String getWineshop_TimeNight() {
		return Wineshop_TimeNight;
	}
	public void setWineshop_TimeNight(String wineshop_TimeNight) {
		Wineshop_TimeNight = wineshop_TimeNight;
	}
	public int getIndent_ID() {
		return Indent_ID;
	}
	public void setIndent_ID(int indent_ID) {
		Indent_ID = indent_ID;
	}
	@Override
	public String toString() {
		return "Fenjianwanbi [Courier_ID=" + Courier_ID + ", Courier_Name="
				+ Courier_Name + ", Wineshop_ID=" + Wineshop_ID
				+ ", Wineshop_Name=" + Wineshop_Name + ", Wineshop_Address="
				+ Wineshop_Address + ", Wineshop_Time=" + Wineshop_Time
				+ ", Wineshop_Shift_Name=" + Wineshop_Shift_Name
				+ ", WIneshop_Telephone=" + WIneshop_Telephone
				+ ", Wineshop_TimeNight=" + Wineshop_TimeNight + ", Indent_ID="
				+ Indent_ID + ", Indent_Status=" + Indent_Status
				+ ", Indent_Time=" + Indent_Time + "]";
	}
	public String getIndent_Status() {
		return Indent_Status;
	}
	public void setIndent_Status(String indent_Status) {
		Indent_Status = indent_Status;
	}
	public String getIndent_Time() {
		return Indent_Time;
	}
	public void setIndent_Time(String indent_Time) {
		Indent_Time = indent_Time;
	}
	private String Wineshop_Address;
	private String Wineshop_Time;
	private String Wineshop_Shift_Name;
	private String WIneshop_Telephone;
	private String Wineshop_TimeNight;
	private int Indent_ID;
	private String Indent_Status;
	private String Indent_Time;
	

}
