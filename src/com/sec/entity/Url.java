package com.sec.entity;

public class Url {
	private int urlId;
	private String urlName;
	public int getUrlId() {
		return urlId;
	}
	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	@Override
	public String toString() {
		return "Url [urlId=" + urlId + ", urlName=" + urlName + "]";
	}
	

}
