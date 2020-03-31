package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FenPeiDao;
import com.sec.dao.LogDao;
import com.sec.dao.QunTuiDao;
import com.sec.dao.UappDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Log;
import com.sec.entity.QunTui;
import com.sec.entity.Uapp;

/**
 * Servlet implementation class FenPeiLoginServlet
 */
@WebServlet("/FenPeiLoginServlet")
public class FenPeiLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenPeiLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static int random() {
        Random random = new Random(System.currentTimeMillis());
        int number = 0;
        boolean ok = true;
        do {
            ok = true;
            number = random.nextInt(9000) + 1000;
            int[] digits = {
                number / 1000 % 10,
                number / 100 % 10,
                number / 10 % 10,
                number % 10
            };
            for (int i = 0; i < 4 && ok; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (digits[i] == digits[j]) {
                        ok = false;
                        break;
                    }
                }
            }
             
        } while (!ok);
 
        return number;
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		WineshopDao dao = new WineshopDao();
		String str = request.getParameter("str");
		String patht = request.getParameter("path");
		String loginName = request.getParameter("userName");
		String loginPwd = request.getParameter("password");
		String CID = request.getParameter("CID");
		System.out.println("loginName"+loginName);
		System.out.println("loginPwd"+loginPwd);
		System.out.println("str"+str);
		System.out.println("patht"+patht);
		int a = dao.checkWineshop(loginName , loginPwd );
		System.out.println("a"+a);
		
		
		Date data = new Date();//创建时间对象
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");//设置时间格式
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");//设置时间格式
        String time = df.format(data);//转换时间
        String time1 = df1.format(data);//转换时间
        int n = random();//生成随机数
        String log_Id = n + time1;//得到前面四位数  
        PrintWriter out = response.getWriter();
        if(a !=0){
        	Log log = new Log();
    		log.setLog_Id(log_Id);
    		log.setLog_Time(time);
    		log.setLog_Name(loginName);
    		log.setLog_Ip(str);
    		log.setLog_Ip_Name(patht);
    		log.setLog_Type("APP登录");
    		log.setLog_Content("酒店登录");
    		LogDao dao2 = new LogDao();
    		dao2.add(log);
    		UappDao app = new UappDao();
			Uapp appname = new Uapp();
			int size = app.checkName(loginName);
			if(size!=1){
				appname.setAppusername(loginName);
				appname.setUname("酒店");
				appname.setUdate(time);
				appname.setUtype("0");
				app.addAPP(appname);
			}
			QunTuiDao dao8 = new QunTuiDao();
			QunTui quntui = new QunTui();
			quntui.setWineshop_UserName(loginName);
			quntui.setWineshop_CID(CID);
			dao8.add(quntui);
			out.print(a);
			out.flush();
			out.close();
        }else {
        	FenPeiDao dao2 = new FenPeiDao();
        	int b = dao2.checkFenPei(loginName, loginPwd);
        	System.out.println("b"+b);
        	Date date = new Date();
        	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        	SimpleDateFormat df3 = new SimpleDateFormat("yyyyMMdd");
        	String time2 = df2.format(date);
        	String time3 = df3.format(date);
        	int m = random();
        	String log_ID = m+time3;
        	//PrintWriter out1= response.getWriter();
        	if(b!=0) {
        		Log log = new Log();
        		log.setLog_Id(log_ID);
        		log.setLog_Time(time2);
        		log.setLog_Name(loginName);
        		log.setLog_Ip(str);
        		log.setLog_Ip_Name(patht);
        		log.setLog_Type("APP登录");
        		log.setLog_Content("酒店收货员登录");
        		LogDao dao3 = new LogDao();
        		dao3.add(log);
        		UappDao app = new UappDao();
    			Uapp appname = new Uapp();
    			int size = app.checkName(loginName);
    			if(size!=1){
    				appname.setAppusername(loginName);
    				appname.setUname("酒店");
    				appname.setUdate(time);
    				appname.setUtype("0");
    				app.addAPP(appname);
        	}
    			
    			out.print(20000);
    			out.flush();
    			out.close();
        }
		
        }
        out.print(0);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
