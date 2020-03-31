package com.sec.entity;

import java.sql.Date;

public class Logistics {
	private int Logistics_ID;
	public int getLogistics_ID() {
		return Logistics_ID;
	}
	public void setLogistics_ID(int logistics_ID) {
		Logistics_ID = logistics_ID;
	}
	public int getIndent_ID() {
		return Indent_ID;
	}
	public void setIndent_ID(int indent_ID) {
		Indent_ID = indent_ID;
	}
	public int getCourier_ID() {
		return Courier_ID;
	}
	public void setCourier_ID(int courier_ID) {
		Courier_ID = courier_ID;
	}
	public Date getLogistics_Distribution_Time() {
		return Logistics_Distribution_Time;
	}
	public void setLogistics_Distribution_Time(Date logistics_Distribution_Time) {
		Logistics_Distribution_Time = logistics_Distribution_Time;
	}
	public Date getLogistics_Delivery_Time() {
		return Logistics_Delivery_Time;
	}
	public void setLogistics_Delivery_Time(Date logistics_Delivery_Time) {
		Logistics_Delivery_Time = logistics_Delivery_Time;
	}
	public float getLogistics_Score() {
		return Logistics_Score;
	}
	public void setLogistics_Score(float logistics_Score) {
		Logistics_Score = logistics_Score;
	}
	private int Indent_ID;
	private int Courier_ID;
	private Date Logistics_Distribution_Time;
	private Date Logistics_Delivery_Time;
	private float Logistics_Score;
	

}
