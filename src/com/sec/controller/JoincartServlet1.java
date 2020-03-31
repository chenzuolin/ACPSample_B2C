package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.entity.Cart;

/**
 * Servlet implementation class JoincartServlet1
 */
@WebServlet("/JoincartServlet1")
public class JoincartServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoincartServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id = (Integer)request.getSession().getAttribute("yy");
		System.out.println(id);
		int xx = (Integer)request.getSession().getAttribute("id");
		int num = Integer.parseInt(request.getParameter(Integer.toString(id)));
		Cart cart = new Cart();
		CartDao dao = new CartDao();
		cart.setWineshop_ID(xx);
		cart.setGreens_ID(id);
		cart.setNumber(num);
		dao.add(cart);
		response.sendRedirect("WineshopList.jsp");

	}

}
