package com.sec.entity;

public class Total {
	private int Total_ID;
	private int Indent_ID;
	private float total;
	private float Greens;
	private String Total_QY;
	public float getGreens() {
		return Greens;
	}
	public void setGreens(float greens) {
		Greens = greens;
	}
	public float getFare() {
		return Fare;
	}
	public void setFare(float fare) {
		Fare = fare;
	}
	private float Fare;
	public int getTotal_ID() {
		return Total_ID;
	}
	public void setTotal_ID(int total_ID) {
		Total_ID = total_ID;
	}
	public int getIndent_ID() {
		return Indent_ID;
	}
	public void setIndent_ID(int indent_ID) {
		Indent_ID = indent_ID;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getTotal_QY() {
		return Total_QY;
	}
	public void setTotal_QY(String total_QY) {
		Total_QY = total_QY;
	}

}
