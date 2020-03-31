package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CourierDao;
import com.sec.entity.Courier;

/**
 * Servlet implementation class CourierloginServlet
 */
@WebServlet("/CourierloginServlet")
public class CourierloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourierloginServlet() {
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
		
		String UserName=request.getParameter("UserName");
		String Password=request.getParameter("Password");
		
		
		CourierDao dao=new CourierDao();
		
		int flat=dao.checkCourier(UserName, Password);
		
		
		if(flat != 0){
			request.getSession().setAttribute("n", flat);
			response.sendRedirect("Courierindex.jsp");
		}
		else{
			PrintWriter out = response.getWriter();
			out.print("<script langage='javascript'>alert('用户名或密码错误！！');window.location.href='CourierLogin.jsp'</script>");
		}
	}

}
