package com.sec.dao;

import java.io.IOException;

import com.sec.entity.Greens;

public class WineshopText {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		GreensDao dao = new GreensDao();
		Greens greens = new Greens();
		greens.setGreens_Grade(6);
		greens.setGreens_ID(1);
		int aa = dao.update2(greens);
		System.out.println(aa);
	}

}
