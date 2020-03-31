package com.sec.entity;

public class GreensXiaoJi {
	private int Greens_ID;
	private String Greens_Type_Name;
	private String Greens_Name;
	private String Greens_Unit;
	private int number;
	private int NN;
	public int getGreens_ID() {
		return Greens_ID;
	}
	public void setGreens_ID(int greens_ID) {
		Greens_ID = greens_ID;
	}
	public String getGreens_Type_Name() {
		return Greens_Type_Name;
	}
	public void setGreens_Type_Name(String greens_Type_Name) {
		Greens_Type_Name = greens_Type_Name;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getNN() {
		return NN;
	}
	public void setNN(int nN) {
		NN = nN;
	}
	@Override
	public String toString() {
		return "GreensXiaoJi [Greens_ID=" + Greens_ID + ", Greens_Type_Name="
				+ Greens_Type_Name + ", Greens_Name=" + Greens_Name
				+ ", Greens_Unit=" + Greens_Unit + ", number=" + number
				+ ", NN=" + NN + "]";
	}
	

}
