package com.sec.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sec.Activity.SB;
import com.sec.Activity.SBDao;

public class A1 implements ServletContextListener {
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根
		SBDao dao = new SBDao();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		dao.up(time);
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根
		long aa = 2 * 60 * 60;
		 Runnable runnable = new Runnable() {  
	            public void run() {
	            	SimpleDateFormat df = new SimpleDateFormat("HHmm");
	        		String time = df.format(new Date());
	            	if(Integer.parseInt(time) > 1800 && Integer.parseInt(time) < 2400){
	            		SBDao dao = new SBDao();
	            		List<SB> list = dao.findAlls();
	            		for(SB s : list){
	            			int off = s.getNum_OFF();
	            			if(off == 0){
	            			
	            			int bs = s.getNum_BS();
	            			if(bs == 0){
	            			int Winesop_ID = s.getWineshop_ID();
	            			Double bb = Double.parseDouble(s.getSB_Num());
	            			Double cc = Double.parseDouble(s.getNum_one());
	            			Double dd = (bb - cc);
	            			String ee = dd.toString();
	            			dao.updates(ee,Winesop_ID);
	            			}else{ 
	            				
	            			}
	            			}else{
	            				
	            			}
	            		}
	            	}else{
	            		SBDao dao = new SBDao();
	            		dao.updates1();
	            	}
	            }  
	        };  
	        ScheduledExecutorService service = Executors  
	                .newSingleThreadScheduledExecutor();  
	        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
	        service.scheduleAtFixedRate(runnable, 1, aa, TimeUnit.SECONDS); 
		
	}
	
	

}
