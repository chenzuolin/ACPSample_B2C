package com.sec.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticFinal {
	public static String FENJIANWANBI = "�ּ���ϵȴ����Ա����";
	public static String INDENT_PEISONGZHONG = "������";
	public static String INDENT_ZHIFU = "����֧��";
	public static String INDENT_WEIJIESHOU = "δ����";
	
	/**
	 * �õ���ʱ�˿̵�ʱ�� 
	 * @return
	 */
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		return df.format(new Date());
	}
}
