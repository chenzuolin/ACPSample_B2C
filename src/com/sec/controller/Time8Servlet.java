package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.XianZhiDao;
import com.sec.entity.XianZhi;

/**
 * Servlet implementation class Time8Servlet
 */
@WebServlet("/Time8Servlet")
public class Time8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Time8Servlet() {
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
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String Time_Star = request.getParameter("Time_Star");
		String Time_End = request.getParameter("Time_End");
		float Price_Money = Float.parseFloat( request.getParameter("Price_Money"));
		XianZhiDao dao= new XianZhiDao();
		XianZhi xianzhi = new XianZhi();
		xianzhi.setTime_Star(Time_Star);
		xianzhi.setTime_End(Time_End);
		xianzhi.setPrice_Money(Price_Money);
		xianzhi.setTime_ID(1);
		dao.update(xianzhi);
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('发布时间成功！！');window.location.href='Time8.jsp'</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
