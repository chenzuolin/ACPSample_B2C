package com.sec.entity;

public class Photo {
	private int Photo_ID;
	private String Photo_time;
	@Override
	public String toString() {
		return "Photo [Photo_ID=" + Photo_ID + ", Photo_time=" + Photo_time
				+ ", Photo_path=" + Photo_path + ", User_ID=" + User_ID
				+ ", Photo_name=" + Photo_name + "]";
	}
	private String Photo_path;
	private int User_ID;
	private String Photo_name;
	public int getPhoto_ID() {
		return Photo_ID;
	}
	public void setPhoto_ID(int photo_ID) {
		Photo_ID = photo_ID;
	}
	public String getPhoto_time() {
		return Photo_time;
	}
	public void setPhoto_time(String photo_time) {
		Photo_time = photo_time;
	}
	public String getPhoto_path() {
		return Photo_path;
	}
	public void setPhoto_path(String photo_path) {
		Photo_path = photo_path;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public String getPhoto_name() {
		return Photo_name;
	}
	public void setPhoto_name(String photo_name) {
		Photo_name = photo_name;
	}
}
