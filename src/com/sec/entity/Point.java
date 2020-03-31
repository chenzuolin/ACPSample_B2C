package com.sec.entity;

public class Point {
	private int Point_ID;
	private int Wineshop_ID;
	private int Point_num;
	private int Point_last;
	private String Point_Status;
	
	public int getPoint_last() {
		return Point_last;
	}
	public void setPoint_last(int point_last) {
		Point_last = point_last;
	}
	public String getPoint_Status() {
		return Point_Status;
	}
	public void setPoint_Status(String point_Status) {
		Point_Status = point_Status;
	}
	public int getPoint_ID() {
		return Point_ID;
	}
	public void setPoint_ID(int point_ID) {
		Point_ID = point_ID;
	}
	public int getWineshop_ID() {
		return Wineshop_ID;
	}
	public void setWineshop_ID(int wineshop_ID) {
		Wineshop_ID = wineshop_ID;
	}
	public int getPoint_num() {
		return Point_num;
	}
	public void setPoint_num(int point_num) {
		Point_num = point_num;
	}

}
