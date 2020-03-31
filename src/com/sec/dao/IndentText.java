package com.sec.dao;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.sec.Activity.SB;
import com.sec.Activity.SBDao;
import com.sec.entity.A1;
import com.sec.entity.Indent;
import com.sec.entity.Red;
import com.sec.entity.XianZhi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;




public class IndentText {

	public static void main(String[] args) {

		SBDao dao = new SBDao();
		List<SB> list = dao.findAlls();
		for(SB s : list){
			int off = s.getNum_OFF();
			if(off == 0){
			
			int bs = s.getNum_BS();
			if(bs == 0){
			Double bb = Double.parseDouble(s.getSB_Num());
			Double cc = Double.parseDouble(s.getNum_one());
			Double dd = (bb - cc);
			String ee = dd.toString();
			System.out.println(ee);
			//dao.updates(ee);
			}else{ 
				
			}
			}else{
				
			}
		}
	
	}
}
		