package com.sec.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import com.sec.entity.GreensXiaoJi;
import com.sec.entity.Wineshop;




public class Greens_JobberText {
	
	public static void main(String[] args)  {
		WineshopDao dao = new WineshopDao();
		System.out.println(dao.findAll1());
		
	}


}
