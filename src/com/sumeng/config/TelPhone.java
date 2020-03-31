package com.sumeng.config;

public class TelPhone {
	public String telPhone;
	public String code;

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TelPhone() {
		super();
	}

	public TelPhone(String telPhone, String code) {
		super();
		this.telPhone = telPhone;
		this.code = code;
	}
	
	
}
