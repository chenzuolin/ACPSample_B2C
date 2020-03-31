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

import com.sec.dao.CGDao;
import com.sec.dao.FJDao;
import com.sec.dao.Greens_JobberDao;
import com.sec.dao.LogDao;
import com.sec.dao.UappDao;
import com.sec.entity.Log;
import com.sec.entity.Uapp;

/**
 * Servlet implementation class BB11Servlet
 */
@WebServlet("/BB11Servlet")
public class BB11Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BB11Servlet() { 
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
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String aa = request.getParameter("userName");
		String bb = request.getParameter("password");
		Greens_JobberDao dao = new Greens_JobberDao();
		String str = request.getParameter("str");
		String path = request.getParameter("path");
		Date data = new Date();//创建时间对象
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");//设置时间格式
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");//设置时间格式
        String time = df.format(data);//转换时间
        String time1 = df1.format(data);//转换时间
        int n = random();//生成随机数
        String log_Id = n + time1;//得到前面四位数
		int a = dao.checkGreen_Jobber1(aa, bb);
		PrintWriter out = response.getWriter();
		if(a == 1){
			Log log = new Log();
			log.setLog_Id(log_Id);
			log.setLog_Time(time);
			log.setLog_Name(aa);
			log.setLog_Ip(str);
			log.setLog_Ip_Name(path);
			log.setLog_Type("APP登录");
			log.setLog_Content("菜商登录");
			LogDao dao2 = new LogDao();
			dao2.add(log);
			UappDao app = new UappDao();
			Uapp appname = new Uapp();
			int size = app.checkName(aa);
			if(size!=1){
				appname.setAppusername(aa);
				appname.setUname("菜商");
				appname.setUdate(time);
				appname.setUtype("0");
				app.addAPP(appname);
				
			}
			out.print(1);
			out.flush();
			out.close();
		}else{
			CGDao dao3 = new CGDao();
			int b = dao3.checkCG(aa, bb);
			if(b == 2){
				Log log = new Log();
				log.setLog_Id(log_Id);
				log.setLog_Time(time);
				log.setLog_Name(aa);
				log.setLog_Ip(str);
				log.setLog_Ip_Name(path);
				log.setLog_Type("APP登录");
				log.setLog_Content("采购员登录");
				LogDao dao2 = new LogDao();
				dao2.add(log);
				UappDao app = new UappDao();
				Uapp appname = new Uapp();
				int size = app.checkName(aa);
				if(size!=1){
					appname.setAppusername(aa);
					appname.setUname("菜商");
					appname.setUdate(time);
					appname.setUtype("0");
					app.addAPP(appname);
					
				}
				out.print(2);
				out.flush();
				out.close();
			}else{
				FJDao dao4 = new FJDao();
				int c = dao4.checkFJ(aa, bb);
				if(c == 3){
					Log log = new Log();
					log.setLog_Id(log_Id);
					log.setLog_Time(time);
					log.setLog_Name(aa);
					log.setLog_Ip(str);
					log.setLog_Ip_Name(path);
					log.setLog_Type("APP登录");
					log.setLog_Content("分拣员登录");
					LogDao dao2 = new LogDao();
					dao2.add(log);
					UappDao app = new UappDao();
					Uapp appname = new Uapp();
					int size = app.checkName(aa);
					if(size!=1){
						appname.setAppusername(aa);
						appname.setUname("菜商");
						appname.setUdate(time);
						appname.setUtype("0");
						app.addAPP(appname);
						
					}
					out.print(3);
					out.flush();
					out.close();
				}else{
					out.print(10);
					out.flush();
					out.close();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
