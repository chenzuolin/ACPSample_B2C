package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class JDZC1Servlet
 */
@WebServlet("/JDZC1Servlet")
public class JDZC1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDZC1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");  
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
		response.setHeader("X-Powered-By","Jetty");  
		response.setHeader("Access-Control-Allow-Origin", "*");
		String Wineshop_UserName = request.getParameter("Wineshop_UserName");
		
		String Wineshop_Shift_Name = request.getParameter("Wineshop_Shift_Name");
		//String Wineshop_Nature = request.getParameter("Wineshop_Nature");
		String Wineshop_QQ = request.getParameter("Wineshop_QQ");
		String Wineshop_WeChat = request.getParameter("Wineshop_WeChat");
		String Wineshop_Number = request.getParameter("Wineshop_Number");
		//String Wineshop_Time = request.getParameter("Wineshop_Time");
		//String Wineshop_TimeNight = request.getParameter("Wineshop_TimeNight");
		
		
		WineshopDao dao = new WineshopDao();
		int a = dao.findUserByID2(Wineshop_UserName);
		Wineshop wineshop = new Wineshop();
		wineshop.setWineshop_Shift_Name(Wineshop_Shift_Name);
		//wineshop.setWineshop_Nature("∆’Õ®æ∆µÍ");
		wineshop.setWineshop_QQ(Wineshop_QQ);
		wineshop.setWineshop_WeChat(Wineshop_WeChat);
		wineshop.setWineshop_Number(Wineshop_Number);
		//wineshop.setWineshop_Time(Wineshop_Time);
		//wineshop.setWineshop_TimeNight(Wineshop_TimeNight);
		wineshop.setWineshop_ID(a);
		dao.update88(wineshop);
		
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
	}

}
