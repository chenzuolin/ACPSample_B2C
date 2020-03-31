package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Courier_WineshopDao;
import com.sec.entity.Courier_Wineshop;

/**
 * Servlet implementation class FenpeiServlet
 */
@WebServlet("/FenpeiServlet")
public class FenpeiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenpeiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String Wineshop_Name=request.getParameter("Wineshop_Name");
		System.out.println(Wineshop_Name);
		
		Courier_Wineshop courier_wineshop1 = new Courier_Wineshop();
		
		courier_wineshop1.setCourier_ID(id);
		courier_wineshop1.setAllot(Wineshop_Name);
		
		Courier_WineshopDao courier_wineshop=new Courier_WineshopDao();
		courier_wineshop.add(courier_wineshop1);
		
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('∑÷≈‰≥…π¶');window.location.href='fenpei.jsp'</script>");
	}

}
