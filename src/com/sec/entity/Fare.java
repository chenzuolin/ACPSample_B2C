package com.sec.entity;

public class Fare {
	private int Fare_ID;
	public int getFare_ID() {
		return Fare_ID;
	}
	public void setFare_ID(int fare_ID) {
		Fare_ID = fare_ID;
	}
	public float getFare_Axiom_Price() {
		return Fare_Axiom_Price;
	}
	public void setFare_Axiom_Price(float fare_Axiom_Price) {
		Fare_Axiom_Price = fare_Axiom_Price;
	}
	public String getFare_Type() {
		return Fare_Type;
	}
	public void setFare_Type(String fare_Type) {
		Fare_Type = fare_Type;
	}
	private float Fare_Axiom_Price;
	private String Fare_Type;
	

}
