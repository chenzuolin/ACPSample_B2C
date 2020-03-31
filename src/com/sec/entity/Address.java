package com.sec.entity;

public class Address {
	private int Address_ID;
	public int getAddress_ID() {
		return Address_ID;
	}
	public void setAddress_ID(int address_ID) {
		Address_ID = address_ID;
	}
	public int getWineshop_ID() {
		return Wineshop_ID;
	}
	public void setWineshop_ID(int wineshop_ID) {
		Wineshop_ID = wineshop_ID;
	}
	public String getAddress_Name() {
		return Address_Name;
	}
	public void setAddress_Name(String address_Name) {
		Address_Name = address_Name;
	}
	private int Wineshop_ID;
	private String Address_Name;

}
