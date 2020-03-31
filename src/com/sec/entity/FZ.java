package com.sec.entity;

public class FZ {
	private int FZ_ID;
	private int Indent_ID;
	private String CG_Name;
	private String FJ_Name;
	private String XD_Time;
	private String CG_Time;
	private String FJ_Time;
	
	private String FenPei_UserName;
	private String FenPei_Time;
	private String finish_time;
	private String address;
	public String getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFenPei_UserName() {
		return FenPei_UserName;
	}
	public void setFenPei_UserName(String fenPei_UserName) {
		FenPei_UserName = fenPei_UserName;
	}
	public String getFenPei_Time() {
		return FenPei_Time;
	}
	public void setFenPei_Time(String fenPei_Time) {
		FenPei_Time = fenPei_Time;
	}
	
	public String getXD_Time() {
		return XD_Time;
	}
	public void setXD_Time(String xD_Time) {
		XD_Time = xD_Time;
	}
	public String getCG_Time() {
		return CG_Time;
	}
	public void setCG_Time(String cG_Time) {
		CG_Time = cG_Time;
	}
	public String getFJ_Time() {
		return FJ_Time;
	}
	public void setFJ_Time(String fJ_Time) {
		FJ_Time = fJ_Time;
	}
	public String getPS_Time() {
		return PS_Time;
	}
	public void setPS_Time(String pS_Time) {
		PS_Time = pS_Time;
	}
	private String PS_Time;
	public int getFZ_ID() {
		return FZ_ID;
	}
	public void setFZ_ID(int fZ_ID) {
		FZ_ID = fZ_ID;
	}
	public int getIndent_ID() {
		return Indent_ID;
	}
	public void setIndent_ID(int indent_ID) {
		Indent_ID = indent_ID;
	}
	public String getCG_Name() {
		return CG_Name;
	}
	public void setCG_Name(String cG_Name) {
		CG_Name = cG_Name;
	}
	public String getFJ_Name() {
		return FJ_Name;
	}
	public void setFJ_Name(String fJ_Name) {
		FJ_Name = fJ_Name;
	}
	private String Courier_Name;
	public String getCourier_Name() {
		return Courier_Name;
	}
	public void setCourier_Name(String courier_Name) {
		Courier_Name = courier_Name;
	}

}
