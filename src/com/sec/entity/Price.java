package com.sec.entity;

public class Price {
	private int Price_ID;
	public int getPrice_ID() {
		return Price_ID;
	}
	public void setPrice_ID(int price_ID) {
		Price_ID = price_ID;
	}
	public float getPrice_num() {
		return Price_num;
	}
	public void setPrice_num(float price_num) {
		Price_num = price_num;
	}
	public int getWineshop_ID() {
		return Wineshop_ID;
	}
	public void setWineshop_ID(int wineshop_ID) {
		Wineshop_ID = wineshop_ID;
	}
	private float Price_num;
	private int Wineshop_ID;
	private String Indent_PayID;
	public String getIndent_PayID() {
		return Indent_PayID;
	}
	public void setIndent_PayID(String indent_PayID) {
		Indent_PayID = indent_PayID;
	}

}
