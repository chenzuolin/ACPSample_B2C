package com.sec.entity;

import java.io.Serializable;

public class Wineshop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Wineshop_ID;
	//注册时间
	private String Wineshop_Date;
	private String Wineshop_Password;
	private String Wineshop_QY;
	private int Role_ID;
	private String Wineshop_Name;
	private int Regionality_ID;
	private String Wineshop_Aptitude;
	private int Wineshop_Condition;
	private String Wineshop_Address;
	private String Wineshop_Shift_Name;
	private String Wineshop_Telephone;
	private String Wineshop_UserName;
	private int Wineshop_Class;
	private String Wineshop_Nature;
	private String Wineshop_QQ;
	private String Wineshop_danwei_name;//营业执照单位名称
	private String Wineshop_faren;//营业执照法人
	private String Wineshop_addr;//营业执照地址
	private String startTime;//营业执照成立日期
	private String endTime;//营业执照有效期
	private String Wineshop_wtype;//营业执照类型
	private String Wineshop_Number;
	private String shopImg;
	private int Logout;
	private String image;
	private int sex;
	private String petName;
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
	public int getRegionality_ID() {
		return Regionality_ID;
	}
	public void setRegionality_ID(int regionality_ID) {
		Regionality_ID = regionality_ID;
	}
	
	public String getWineshop_Aptitude() {
		return Wineshop_Aptitude;
	}
	public void setWineshop_Aptitude(String wineshop_Aptitude) {
		Wineshop_Aptitude = wineshop_Aptitude;
	}
	public int getWineshop_Condition() {
		return Wineshop_Condition;
	}
	public void setWineshop_Condition(int wineshop_Condition) {
		Wineshop_Condition = wineshop_Condition;
	}
	public String getWineshop_Address() {
		return Wineshop_Address;
	}
	public void setWineshop_Address(String wineshop_Address) {
		Wineshop_Address = wineshop_Address;
	}
	public String getWineshop_Shift_Name() {
		return Wineshop_Shift_Name;
	}
	public void setWineshop_Shift_Name(String wineshop_Shift_Name) {
		Wineshop_Shift_Name = wineshop_Shift_Name;
	}
	
	public int getWineshop_Class() {
		return Wineshop_Class;
	}
	public void setWineshop_Class(int wineshop_Class) {
		Wineshop_Class = wineshop_Class;
	}
	public String getWineshop_Nature() {
		return Wineshop_Nature;
	}
	public void setWineshop_Nature(String wineshop_Nature) {
		Wineshop_Nature = wineshop_Nature;
	}
	public String getWineshop_WeChat() {
		return Wineshop_WeChat;
	}
	public void setWineshop_WeChat(String wineshop_WeChat) {
		Wineshop_WeChat = wineshop_WeChat;
	}

	public String getWineshop_UserName() {
		return Wineshop_UserName;
	}
	public void setWineshop_UserName(String wineshop_UserName) {
		Wineshop_UserName = wineshop_UserName;
	}
	public String getWineshop_Password() {
		return Wineshop_Password;
	}
	public void setWineshop_Password(String wineshop_Password) {
		Wineshop_Password = wineshop_Password;
	}
	public int getRole_ID() {
		return Role_ID;
	}
	public void setRole_ID(int role_ID) {
		Role_ID = role_ID;
	}
	
	public String getWineshop_danwei_name() {
		return Wineshop_danwei_name;
	}
	public void setWineshop_danwei_name(String wineshop_danwei_name) {
		Wineshop_danwei_name = wineshop_danwei_name;
	}
	public String getWineshop_faren() {
		return Wineshop_faren;
	}
	public void setWineshop_faren(String wineshop_faren) {
		Wineshop_faren = wineshop_faren;
	}
	public String getWineshop_addr() {
		return Wineshop_addr;
	}
	public void setWineshop_addr(String wineshop_addr) {
		Wineshop_addr = wineshop_addr;
	}
	public String getWineshop_wtype() {
		return Wineshop_wtype;
	}
	public void setWineshop_wtype(String wineshop_wtype) {
		Wineshop_wtype = wineshop_wtype;
	}
	
	
	public String getWineshop_Number() {
		return Wineshop_Number;
	}
	public void setWineshop_Number(String wineshop_Number) {
		Wineshop_Number = wineshop_Number;
	}
	public String getWineshop_Telephone() {
		return Wineshop_Telephone;
	}
	public void setWineshop_Telephone(String wineshop_Telephone) {
		Wineshop_Telephone = wineshop_Telephone;
	}

	
	public String getWineshop_QQ() {
		return Wineshop_QQ;
	}
	public String getWineshop_Time() {
		return Wineshop_Time;
	}
	public void setWineshop_Time(String wineshop_Time) {
		Wineshop_Time = wineshop_Time;
	}
	public String getWineshop_TimeNight() {
		return Wineshop_TimeNight;
	}
	public void setWineshop_TimeNight(String wineshop_TimeNight) {
		Wineshop_TimeNight = wineshop_TimeNight;
	}
	public void setWineshop_QQ(String wineshop_QQ) {
		Wineshop_QQ = wineshop_QQ;
	}
	private String Wineshop_WeChat;
	private String Wineshop_Time;
	private String Wineshop_TimeNight;
	private String Wineshop_TuiJian;
	public String getWineshop_TuiJian() {
		return Wineshop_TuiJian;
	}
	public void setWineshop_TuiJian(String wineshop_TuiJian) {
		Wineshop_TuiJian = wineshop_TuiJian;
	}
	public String getWineshop_Date() {
		return Wineshop_Date;
	}
	public void setWineshop_Date(String wineshop_Date) {
		Wineshop_Date = wineshop_Date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Wineshop [Wineshop_ID=" + Wineshop_ID + ", Wineshop_Date="
				+ Wineshop_Date + ", Wineshop_Password=" + Wineshop_Password
				+ ", Role_ID=" + Role_ID + ", Wineshop_Name=" + Wineshop_Name
				+ ", Regionality_ID=" + Regionality_ID + ", Wineshop_Aptitude="
				+ Wineshop_Aptitude + ", Wineshop_Condition="
				+ Wineshop_Condition + ", Wineshop_Address=" + Wineshop_Address
				+ ", Wineshop_Shift_Name=" + Wineshop_Shift_Name
				+ ", Wineshop_Telephone=" + Wineshop_Telephone
				+ ", Wineshop_UserName=" + Wineshop_UserName
				+ ", Wineshop_Class=" + Wineshop_Class + ", Wineshop_Nature="
				+ Wineshop_Nature + ", Wineshop_QQ=" + Wineshop_QQ
				+ ", Wineshop_danwei_name=" + Wineshop_danwei_name
				+ ", Wineshop_faren=" + Wineshop_faren + ", Wineshop_addr="
				+ Wineshop_addr + ", startTime=" + startTime + ", endTime="
				+ endTime + ", Wineshop_wtype=" + Wineshop_wtype
				+ ", Wineshop_Number=" + Wineshop_Number + ", Wineshop_WeChat="
				+ Wineshop_WeChat + ", Wineshop_Time=" + Wineshop_Time
				+ ", Wineshop_TimeNight=" + Wineshop_TimeNight
				+ ", Wineshop_TuiJian=" + Wineshop_TuiJian + "]";
	}
	public String getWineshop_QY() {
		return Wineshop_QY;
	}
	public void setWineshop_QY(String wineshop_QY) {
		Wineshop_QY = wineshop_QY;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public int getLogout() {
		return Logout;
	}
	public void setLogout(int logout) {
		Logout = logout;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}

}
