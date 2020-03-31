package com.sumeng.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gexin.fastjson.JSON;
import com.sec.Activity.Activity;
import com.sec.Activity.SB;
import com.sec.entity.Wineshop;
import com.sumeng.service.AllIndent;
import com.sumeng.web.IndentDao;
import com.sumeng.web.MoneyDao;
import com.sumeng.web.SbDao;
import com.sumeng.web.WineshopDao;

public class Test {

	public static void main(String[] args) {
		WineshopDao a = new WineshopDao();
		String checkOpenId = a.checkTel("110");
		if(checkOpenId!="0"){
			System.out.println("++++++++++++");
		}
		System.out.println(checkOpenId);
		
	}
	
}
