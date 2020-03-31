package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.Cart;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class Greens_Jobber_IndentServlet
 */
@WebServlet("/Greens_Jobber_IndentServlet")
public class Greens_Jobber_IndentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greens_Jobber_IndentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IndentDao indent=new IndentDao();
		OrderDao order=new OrderDao();
		CartDao cart=new CartDao();
		
		List<Indent>list=indent.findAll();
		
		List<Order>list1=order.findAll();
		
		List<Cart>list2=cart.findAll();
		
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		
		request.getRequestDispatcher("Greens_JobberIndent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
