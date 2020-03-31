package com.sec.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_JobberDao;
import com.sec.entity.Greens_Jobber;

/**
 * Servlet implementation class ZhuceServlet
 */
@WebServlet("/CSZEServlet")
public class CSZEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSZEServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
 
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
         //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
       
		String Greens_Jobber_UserName = request.getParameter("UserName");
		String Greens_Jobber_Password = request.getParameter("password");
		String Greens_Jobber_Name = request.getParameter("Greens_Jobber_Name");
		String Greens_Jobber_Aptitude = request.getParameter("Greens_Jobber_Aptitude");
		String Greens_Jobber_Address = request.getParameter("Greens_Jobber_Address");
		String Greens_Jobber_Shift_Name = request.getParameter("Greens_Jobber_Shift_Name");
		String Greens_Jobber_Telephone = request.getParameter("user_phone1");	
		String Greens_Jobber_QQ = request.getParameter("Greens_Jobber_QQ");	
		String Greens_Jobber_WeChat = request.getParameter("Greens_Jobber_WeChat");
		Greens_Jobber greens_Jobber = new Greens_Jobber();
		Greens_JobberDao dao = new Greens_JobberDao();
		
		greens_Jobber.setGreens_Jobber_UserName(Greens_Jobber_UserName);
		greens_Jobber.setGreens_Jobber_Password(Greens_Jobber_Password);
		greens_Jobber.setRole_ID(1);
		greens_Jobber.setGreens_Jobber_Name(Greens_Jobber_Name);
		greens_Jobber.setGreens_Jobber_Aptitude(Greens_Jobber_Aptitude);
		greens_Jobber.setGreens_Jobber_Address(Greens_Jobber_Address);
		greens_Jobber.setGreens_Jobber_Shift_Name(Greens_Jobber_Shift_Name);
		greens_Jobber.setGreens_Jobber_Telephone(Greens_Jobber_Telephone);
		
        
        greens_Jobber.setGreens_Jobber_Time(df.format(new Date()));
		greens_Jobber.setRegionality_ID(1);
		greens_Jobber.setGreens_Jobber_QQ(Greens_Jobber_QQ);
		greens_Jobber.setGreens_Jobber_WeChat(Greens_Jobber_WeChat);
		greens_Jobber.setGreens_Jobber_Grade("1");
		dao.add(greens_Jobber);
		/*System.out.println(greens_Jobber);
		System.out.println(Greens_Jobber_UserName);
		System.out.println(Greens_Jobber_Password);
		System.out.println(Greens_Jobber_Name);
		System.out.println(Greens_Jobber_Aptitude);
		System.out.println(Greens_Jobber_Address);
		System.out.println(Greens_Jobber_Shift_Name);
		System.out.println(Greens_Jobber_Telephone);
		System.out.println(Greens_Jobber_QQ);
		System.out.println(Greens_Jobber_WeChat);
		System.out.println(df.format(new Date()));
		/*String userName = request.getParameter("Greens_Jobber_Name");
		String password = request.getParameter("password");
		User user = new User();
		UserDao dao = new UserDao();
		user.setUser_Name(userName);
		user.setUser_Password(password);
		user.setRole_ID(2);
		user.setDepartment_ID(1);
		dao.add(user);*/
		
		
		
	}

}
