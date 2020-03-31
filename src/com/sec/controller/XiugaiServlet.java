package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_JobberDao;
import com.sec.entity.Greens_Jobber;

/**
 * Servlet implementation class XiugaiServlet
 */
@WebServlet("/XiugaiServlet")
public class XiugaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiugaiServlet() {
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
		int o=(Integer)request.getSession().getAttribute("a");
		String Greens_Jobber_UserName=request.getParameter("Greens_Jobber_UserName");
		String Greens_Jobber_Password=request.getParameter("Greens_Jobber_Passwrod");
		String Greens_Jobber_Address=request.getParameter("Greens_Jobber_Address");
		String Greens_Jobber_Shift_Name=request.getParameter("Greens_Jobber_Shift_Name");
		String Greens_Jobber_Telephone=request.getParameter("Greens_Jobber_Telephone");
		String Greens_Jobber_QQ=request.getParameter("Greens_Jobber_QQ");
		String Greens_Jobber_WeChat=request.getParameter("Greens_Jobber_WeChat");
		
		Greens_JobberDao dao=new Greens_JobberDao();
		Greens_Jobber greens_Jobber=new Greens_Jobber();
		
		
		greens_Jobber.setGreens_Jobber_UserName(Greens_Jobber_UserName);
		greens_Jobber.setGreens_Jobber_Password(Greens_Jobber_Password);
		greens_Jobber.setGreens_Jobber_Address(Greens_Jobber_Address);
		greens_Jobber.setGreens_Jobber_Shift_Name(Greens_Jobber_Shift_Name);
		greens_Jobber.setGreens_Jobber_Telephone(Greens_Jobber_Telephone);
		greens_Jobber.setGreens_Jobber_QQ(Greens_Jobber_QQ);
		greens_Jobber.setGreens_Jobber_WeChat(Greens_Jobber_WeChat);
		greens_Jobber.setGreens_Jobber_ID(o);
	
		dao.update1(greens_Jobber);
		/*System.out.println(o);
		System.out.println(greens_Jobber);
		System.out.println(Greens_Jobber_UserName);
		System.out.println(Greens_Jobber_Password);
		System.out.println(Greens_Jobber_Address);
		System.out.println(Greens_Jobber_Shift_Name);
		System.out.println(Greens_Jobber_Telephone);
		System.out.println(Greens_Jobber_QQ);*/
		
		
	}

}
