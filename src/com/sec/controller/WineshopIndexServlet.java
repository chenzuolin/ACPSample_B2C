package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class WineshopIndexServlet
 */
@WebServlet("/WineshopIndexServlet")
public class WineshopIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WineshopIndexServlet() {
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
		int yy = Integer.parseInt(request.getParameter("id"));
		//int id = (Integer)request.getSession().getAttribute("Indent");
		System.out.println(yy);
		IndentDao dao = new IndentDao();
		OrderDao dao1 = new OrderDao();
		Indent indent = new Indent();
		Order order = new Order();
		indent.setIndent_Status("已完成");
		indent.setIndent_ID(yy);
		dao.update1(indent);
		order.setIndent_Status("已完成");
		order.setIndent_ID(yy);
		dao1.update1(order);
		response.sendRedirect("Indent6.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
