package com.sec.entity;

import java.sql.Date;

public class Courier {
	private int Courier_ID;
	private String Courier_Photo;
	public String getCourier_Photo() {
		return Courier_Photo;
	}
	@Override
	public String toString() {
		return "Courier [Courier_ID=" + Courier_ID + ", Courier_Photo="
				+ Courier_Photo + ", Courier_Name=" + Courier_Name
				+ ", Courier_Telephone=" + Courier_Telephone
				+ ", Courier_Time=" + Courier_Time + ", Regionality_ID="
				+ Regionality_ID + ", Courier_Vehicle=" + Courier_Vehicle
				+ ", Courier_Password=" + Courier_Password + "]";
	}
	public void setCourier_Photo(String courier_Photo) {
		Courier_Photo = courier_Photo;
	}
	public int getCourier_ID() {
		return Courier_ID;
	}
	public void setCourier_ID(int courier_ID) {
		Courier_ID = courier_ID;
	}
	public String getCourier_Name() {
		return Courier_Name;
	}
	public void setCourier_Name(String courier_Name) {
		Courier_Name = courier_Name;
	}
	public String getCourier_Telephone() {
		return Courier_Telephone;
	}
	public void setCourier_Telephone(String courier_Telephone) {
		Courier_Telephone = courier_Telephone;
	}
	
	public int getRegionality_ID() {
		return Regionality_ID;
	}
	public void setRegionality_ID(int regionality_ID) {
		Regionality_ID = regionality_ID;
	}
	public String getCourier_Vehicle() {
		return Courier_Vehicle;
	}
	public void setCourier_Vehicle(String courier_Vehicle) {
		Courier_Vehicle = courier_Vehicle;
	}
	private String Courier_Name;
	private String Courier_Telephone;
	private String Courier_Time;
	public String getCourier_Time() {
		return Courier_Time;
	}
	public void setCourier_Time(String courier_Time) {
		Courier_Time = courier_Time;
	}
	private int Regionality_ID;
	private String Courier_Vehicle;
	private String Courier_Password;
	public String getCourier_Password() {
		return Courier_Password;
	}
	public void setCourier_Password(String courier_Password) {
		Courier_Password = courier_Password;
	}

}
