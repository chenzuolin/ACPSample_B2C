package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Courier_WineshopDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Courier_Wineshop;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class JDZCServlet
 */
@WebServlet("/JDZCServlet")
public class JDZCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDZCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		String Wineshop_UserName = request.getParameter("Wineshop_UserName");
		System.out.println("Wineshop_UserName="+Wineshop_UserName);
		String Wineshop_Password1 = request.getParameter("Wineshop_Password1");
		System.out.println("Wineshop_Password1="+Wineshop_Password1);
		String Wineshop_Name = request.getParameter("Wineshop_Name");
		System.out.println("Wineshop_Name="+Wineshop_Name);
		String Wineshop_Number = request.getParameter("Wineshop_Number");
		System.out.println("Wineshop_Number="+Wineshop_Number);
		String Wineshop_Telephone = request.getParameter("Wineshop_Telephone");
		System.out.println("Wineshop_Telephone="+Wineshop_Telephone);
		//String Wineshop_Nature = request.getParameter("Wineshop_Nature");
		//System.out.println("Wineshop_Nature="+Wineshop_Nature);
		String Wineshop_Address = request.getParameter("Wineshop_Address");
		System.out.println("Wineshop_Address="+Wineshop_Address);
		String Wineshop_QQ = request.getParameter("Wineshop_QQ");
		System.out.println("Wineshop_QQ="+Wineshop_QQ);
		String Wineshop_WeChat = request.getParameter("Wineshop_WeChat");
		System.out.println("Wineshop_WeChat="+Wineshop_WeChat);
		String Wineshop_Shift_Name = request.getParameter("Wineshop_Shift_Name");
		System.out.println("Wineshop_Shift_Name="+Wineshop_Shift_Name);
		String Wineshop_Time = request.getParameter("Wineshop_Time");
		String Wineshop_TimeNight = request.getParameter("Wineshop_TimeNight");
		System.out.println("Wineshop_Time"+Wineshop_Time);
		
		//String Wineshop_TimeNight = request.getParameter("Wineshop_TimeNight");
		//System.out.println("Wineshop_TimeNight"+Wineshop_TimeNight);
		String Wineshop_TuiJian = request.getParameter("Wineshop_TuiJian");
		String qy = request.getParameter("quyu");
		Wineshop wineshop = new Wineshop();
		wineshop.setWineshop_UserName(Wineshop_UserName);
		wineshop.setWineshop_Password(Wineshop_Password1);
		wineshop.setRole_ID(2);
		wineshop.setWineshop_Name(Wineshop_Name);
		wineshop.setRegionality_ID(3);
		wineshop.setWineshop_Aptitude("");
		wineshop.setWineshop_Condition(1);
		wineshop.setWineshop_Address(Wineshop_Address);
		wineshop.setWineshop_Shift_Name("");
		wineshop.setWineshop_Telephone(Wineshop_Telephone);
		wineshop.setWineshop_Class(1);
		wineshop.setWineshop_Nature("∆’Õ®æ∆µÍ");
		wineshop.setWineshop_QQ("");
		wineshop.setWineshop_WeChat("");
		wineshop.setWineshop_Number("");
		wineshop.setWineshop_Time(Wineshop_Time);
		wineshop.setWineshop_TimeNight(Wineshop_TimeNight);
		wineshop.setWineshop_TuiJian(Wineshop_TuiJian);
		wineshop.setWineshop_Date(time);
		wineshop.setWineshop_QY(qy);
		WineshopDao dao = new WineshopDao();
		dao.add(wineshop);
		Courier_WineshopDao dao8 = new Courier_WineshopDao();
		Courier_Wineshop courier_Wineshop = new Courier_Wineshop();
		courier_Wineshop.setCourier_ID(21);
		courier_Wineshop.setAllot(Wineshop_Name);
		dao8.add(courier_Wineshop);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
