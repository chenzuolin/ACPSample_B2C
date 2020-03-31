package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.OrderDao;
import com.sec.entity.Order;
import com.sumeng.service.AllIndent;
import com.sumeng.web.IndentDao;

/**
 * Servlet implementation class CheckIndent
 */
@WebServlet("/CheckIndent")
public class CheckIndent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIndent() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		IndentDao dao = new IndentDao();
		AllIndent dd = dao.findAllIndent(id);
		OrderDao or = new OrderDao();
		List<Order> green = or.findUserByID1(id);
		request.setAttribute("d", dd);
		request.setAttribute("gr", green);
		request.getRequestDispatcher("checkIndent.jsp").forward(request, response);
	}

}
