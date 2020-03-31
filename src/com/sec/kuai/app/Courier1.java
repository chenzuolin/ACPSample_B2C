package com.sec.kuai.app;

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

import com.sec.dao.CourierDao;
import com.sec.dao.LogDao;
import com.sec.dao.UappDao;
import com.sec.entity.Log;
import com.sec.entity.Uapp;

/**
 * Servlet implementation class Courier1
 */
@WebServlet("/Courier1")
public class Courier1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Courier1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);


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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		CourierDao dao=new CourierDao();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String str = request.getParameter("str");
		String path = request.getParameter("path");
		Date data = new Date();//创建时间对象
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");//设置时间格式
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");//设置时间格式
        String time = df.format(data);//转换时间
        String time1 = df1.format(data);//转换时间
        int n = random();//生成随机数
        String log_Id = n + time1;//得到前面四位数
		System.out.println(username);
		System.out.println(password);
		int x=dao.checkCourier(username, password);
		LogDao logDao = new LogDao();
		PrintWriter out=response.getWriter();
		if(x != 0) {
			Log log = new Log();
			log.setLog_Id(log_Id);
			log.setLog_Time(time);
			log.setLog_Name(username);
			log.setLog_Ip(str);
			log.setLog_Ip_Name(path);
			log.setLog_Type("APP登录");
			log.setLog_Content("快递员登录");
			logDao.add(log);
			UappDao app = new UappDao();
			Uapp appname = new Uapp();
			int size = app.checkName(username);
			if(size!=1){
				appname.setAppusername(username);
				appname.setUname("快递员");
				appname.setUdate(time);
				appname.setUtype("0");
				app.addAPP(appname);
			}
			out.print(1);
			out.flush();
			out.close();
		}
		out.print(0);
		out.flush();
		out.close();
	}
	}
