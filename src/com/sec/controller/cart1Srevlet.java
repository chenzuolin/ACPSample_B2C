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
 * Servlet implementation class cart1Srevlet
 */
@WebServlet("/cart1Srevlet")
public class cart1Srevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart1Srevlet() {
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
		int yy = Integer.parseInt(request.getParameter("id"));
		//String number = request.getParameter("sum");
		request.getSession().setAttribute("yy", yy);
		response.sendRedirect("details.jsp");

		System.out.println(yy);
		/*CartDao dao = new CartDao();
		Cart cart = new Cart();
		cart.setGreens_ID(id);
		cart.setNumber(number);
		dao.add(cart);

		System.out.println(number);*/
	}

}
