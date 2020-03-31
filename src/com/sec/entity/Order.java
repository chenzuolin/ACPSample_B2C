package com.sec.entity;

public class Order {
	private int Order_ID;
	private float Greens_Price;
	private int Greens_BiaoJi;
	private String Greens_Type_Name;
	public float getGreens_Price() {
		return Greens_Price;
	}
	public void setGreens_Price(float greens_Price) {
		Greens_Price = greens_Price;
	}
	public int getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(int order_ID) {
		Order_ID = order_ID;
	}
	public int getIndent_ID() {
		return Indent_ID;
	}
	public void setIndent_ID(int indent_ID) {
		Indent_ID = indent_ID;
	}
	public int getGreens_ID() {
		return Greens_ID;
	}
	public void setGreens_ID(int greens_ID) {
		Greens_ID = greens_ID;
	}
	public String getOrder_Requirement() {
		return Order_Requirement;
	}
	public void setOrder_Requirement(String order_Requirement) {
		Order_Requirement = order_Requirement;
	}
	public String getIndent_Status() {
		return Indent_Status;
	}
	public void setIndent_Status(String indent_Status) {
		Indent_Status = indent_Status;
	}
	private int Indent_ID;
	private int Greens_ID;
	private String Indent_Time;
	public String getIndent_Time() {
		return Indent_Time;
	}
	public void setIndent_Time(String indent_Time) {
		Indent_Time = indent_Time;
	}
	private int Number;
	private String Greens_Unit;
	public String getGreens_Unit() {
		return Greens_Unit;
	}
	public void setGreens_Unit(String greens_Unit) {
		Greens_Unit = greens_Unit;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getGreens_Name() {
		return Greens_Name;
	}
	public void setGreens_Name(String greens_Name) {
		Greens_Name = greens_Name;
	}
	private String Greens_Name;
	private int Wineshop_ID;
	public int getWineshop_ID() {
		return Wineshop_ID;
	}
	public void setWineshop_ID(int wineshop_ID) {
		Wineshop_ID = wineshop_ID;
	}
	private String Order_Requirement;
	private String Indent_Status;
	private String Order_Remark;
	public String getOrder_Remark() {
		return Order_Remark;
	}
	public void setOrder_Remark(String order_Remark) {
		Order_Remark = order_Remark;
	}
	public int getGreens_BiaoJi() {
		return Greens_BiaoJi;
	}
	public void setGreens_BiaoJi(int greens_BiaoJi) {
		Greens_BiaoJi = greens_BiaoJi;
	}
	public String getGreens_Type_Name() {
		return Greens_Type_Name;
	}
	public void setGreens_Type_Name(String greens_Type_Name) {
		Greens_Type_Name = greens_Type_Name;
	}

}
