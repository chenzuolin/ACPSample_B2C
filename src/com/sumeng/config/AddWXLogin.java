package com.sumeng.config;

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

import com.gexin.fastjson.JSON;
import com.sec.dao.LogDao;
import com.sec.entity.Log;
import com.sec.entity.Wineshop;
import com.sumeng.web.WineshopDao;

/**
 * Servlet implementation class AddWXLogin
 */
@WebServlet("/WXlogin")
public class AddWXLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWXLogin() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String openid = request.getParameter("openid");
		String petName = request.getParameter("petName");
		String image = request.getParameter("img");
		int sex = Integer.parseInt(request.getParameter("sex"));
		WineshopDao a = new WineshopDao();
		Wineshop checkOpenId = a.checkOpenId(openid);
		PrintWriter out = response.getWriter();
		Date data = new Date();//创建时间对象
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");//设置时间格式
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");//设置时间格式
        String time = df.format(data);//转换时间
		String time1 = df1.format(data);//转换时间
        int n = random();//生成随机数
        String log_Id = n + time1;//得到前面四位数  
		if(checkOpenId == null ){
			String addWXLogin = a.addWXLogin(openid, petName, sex, image);
			Wineshop aa = a.checkOpenId(openid);
			Log log = new Log();
    		log.setLog_Id(log_Id);
    		log.setLog_Time(time);
    		log.setLog_Name(petName);
    		log.setLog_Ip("");
    		log.setLog_Ip_Name("");
    		log.setLog_Type("微信小程序登录");
    		log.setLog_Content("酒店登录");
    		LogDao dao2 = new LogDao();
    		dao2.add(log);
    		out.print(JSON.toJSON(aa));
			out.flush();
			out.close();
		}else if(checkOpenId != null){ 
			Log log = new Log();
    		log.setLog_Id(log_Id);
    		log.setLog_Time(time);
    		log.setLog_Name(petName);
    		log.setLog_Ip("");
    		log.setLog_Ip_Name("");
    		log.setLog_Type("微信小程序登录");
    		log.setLog_Content("酒店登录");
    		LogDao dao2 = new LogDao();
    		dao2.add(log);
			out.print(JSON.toJSON(checkOpenId));
			out.flush();
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
