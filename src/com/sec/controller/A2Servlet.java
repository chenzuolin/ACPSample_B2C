package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.WineshopDao;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class A2Servlet
 */
@WebServlet("/A2Servlet")
public class A2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String aa = request.getParameter("zz");
		String bb = request.getParameter("yy");
		System.out.println(aa);
		System.out.println(bb);
		String cc = request.getParameter("xx");
		int dd = Integer.parseInt(request.getParameter("aa"));
		
		System.out.println(cc);
		WineshopDao dao = new WineshopDao();
		Wineshop wineshop = new Wineshop();
		wineshop.setWineshop_Address(bb);
		wineshop.setWineshop_Nature(aa);
		wineshop.setWineshop_ID(dd);
		dao.update2(wineshop);
		response.sendRedirect("A1.jsp");
	}

}
