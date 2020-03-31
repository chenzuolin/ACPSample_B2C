package com.sec.entity;

public class Sousuo {
	private int ID;
	private String Greens_Name;
	private String Greens_Unit;
	private float Greens_Price;
	private float Greens_Market_Price;
	private String Greens_Period;
	private int Greens_Minnumber;
	private String Greens_Norms;
	public String getGreens_Photo() {
		return Greens_Photo;
	}
	public void setGreens_Photo(String greens_Photo) {
		Greens_Photo = greens_Photo;
	}
	private String Greens_Photo;
	@Override
	public String toString() {
		return "Sousuo [ID=" + ID + ", Greens_Name=" + Greens_Name
				+ ", Greens_Unit=" + Greens_Unit + ", Greens_Price="
				+ Greens_Price + ", Greens_Market_Price=" + Greens_Market_Price
				+ ", Greens_Period=" + Greens_Period + ", Greens_Minnumber="
				+ Greens_Minnumber + ", Greens_Norms=" + Greens_Norms
				+ ", Greens_Number=" + Greens_Number + ", Greens_Class="
				+ Greens_Class + ", Greens_Remark=" + Greens_Remark + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getGreens_Name() {
		return Greens_Name;
	}
	public void setGreens_Name(String greens_Name) {
		Greens_Name = greens_Name;
	}
	public String getGreens_Unit() {
		return Greens_Unit;
	}
	public void setGreens_Unit(String greens_Unit) {
		Greens_Unit = greens_Unit;
	}
	public float getGreens_Price() {
		return Greens_Price;
	}
	public void setGreens_Price(float greens_Price) {
		Greens_Price = greens_Price;
	}
	public float getGreens_Market_Price() {
		return Greens_Market_Price;
	}
	public void setGreens_Market_Price(float greens_Market_Price) {
		Greens_Market_Price = greens_Market_Price;
	}
	public String getGreens_Period() {
		return Greens_Period;
	}
	public void setGreens_Period(String greens_Period) {
		Greens_Period = greens_Period;
	}
	public int getGreens_Minnumber() {
		return Greens_Minnumber;
	}
	public void setGreens_Minnumber(int greens_Minnumber) {
		Greens_Minnumber = greens_Minnumber;
	}
	public String getGreens_Norms() {
		return Greens_Norms;
	}
	public void setGreens_Norms(String greens_Norms) {
		Greens_Norms = greens_Norms;
	}
	public int getGreens_Number() {
		return Greens_Number;
	}
	public void setGreens_Number(int greens_Number) {
		Greens_Number = greens_Number;
	}
	public String getGreens_Class() {
		return Greens_Class;
	}
	public void setGreens_Class(String greens_Class) {
		Greens_Class = greens_Class;
	}
	public String getGreens_Remark() {
		return Greens_Remark;
	}
	public void setGreens_Remark(String greens_Remark) {
		Greens_Remark = greens_Remark;
	}
	private int Greens_Number;
	private String Greens_Class;
	private String Greens_Remark;
}
