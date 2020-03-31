package com.sec.entity;

import java.sql.Date;

public class Dynamic {
	private int Dynamic_ID;
	public int getDynamic_ID() {
		return Dynamic_ID;
	}
	public void setDynamic_ID(int dynamic_ID) {
		Dynamic_ID = dynamic_ID;
	}
	public int getGreens_ID() {
		return Greens_ID;
	}
	public void setGreens_ID(int greens_ID) {
		Greens_ID = greens_ID;
	}
	
	private int Greens_ID;
	private float Dynamic_Price;
	public float getDynamic_Price() {
		return Dynamic_Price;
	}
	public void setDynamic_Price(float dynamic_Price) {
		Dynamic_Price = dynamic_Price;
	}
	public float getDynamic_Market_Price() {
		return Dynamic_Market_Price;
	}
	public void setDynamic_Market_Price(float dynamic_Market_Price) {
		Dynamic_Market_Price = dynamic_Market_Price;
	}

	private String Dynamic_Time;
	public String getDynamic_Time() {
		return Dynamic_Time;
	}
	private float Dynamic_Market_Price;
	
	public void setDynamic_Time(String dynamic_Time) {
		Dynamic_Time = dynamic_Time;
	}

}
