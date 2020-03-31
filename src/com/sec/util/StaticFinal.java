package com.sec.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticFinal {
	public static String FENJIANWANBI = "分拣完毕等待快递员接收";
	public static String INDENT_PEISONGZHONG = "配送中";
	public static String INDENT_ZHIFU = "正在支付";
	public static String INDENT_WEIJIESHOU = "未接收";
	
	/**
	 * 得到此时此刻的时间 
	 * @return
	 */
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		return df.format(new Date());
	}
}
