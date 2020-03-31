package com.sec.entity;

public class Cart {
	private int Cart_ID;
	
	public int getCart_ID() {
		return Cart_ID;
	}
	public void setCart_ID(int cart_ID) {
		Cart_ID = cart_ID;
	}
	public int getGreens_ID() {
		return Greens_ID;
	}
	public void setGreens_ID(int greens_ID) {
		Greens_ID = greens_ID;
	}
	
	private int Greens_ID;
	private int Number;
	private String remark;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}

	private int Wineshop_ID;

	public int getWineshop_ID() {
		return Wineshop_ID;
	}
	public void setWineshop_ID(int wineshop_ID) {
		Wineshop_ID = wineshop_ID;
	}

}
