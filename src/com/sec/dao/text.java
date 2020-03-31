package com.sec.dao;

public class text {
	public static void main(String[] args) {
		String aa = "jiuxian";
		WineshopDao dao = new WineshopDao();
		int checkName = dao.checkName(aa);
		System.out.println(checkName);
	}

}
