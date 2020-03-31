package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.PriceDao;
import com.sec.entity.Price;

/**
 * Servlet implementation class CW1Servlet
 */
@WebServlet("/CW1Servlet")
public class CW1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CW1Servlet() {
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
		int aa = Integer.parseInt(request.getParameter("cc"));
		System.out.println(aa);
		float bb= Float.parseFloat(request.getParameter("bb"));
		int yy = Integer.parseInt(request.getParameter("yy"));
		PriceDao dao = new PriceDao();
		Price price = new Price();
		price.setPrice_num(bb);
		price.setWineshop_ID(aa);
		price.setPrice_ID(yy);
		dao.update(price);
		response.sendRedirect("CW.jsp");                                                                                                                                                                                                                                              
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
