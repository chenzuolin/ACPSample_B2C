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
 * Servlet implementation class zhifuServlet
 */
@WebServlet("/zhifuServlet")
public class zhifuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhifuServlet() {
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
		float aa = Float.parseFloat(request.getParameter("nn"));//�ܼ�
		int bb = (Integer)request.getSession().getAttribute("id");//�Ƶ�ID
		int xx = Integer.parseInt(request.getParameter("xx"));
		PriceDao dao = new PriceDao();
		Price price = new Price();
		price.setPrice_num(aa);
		price.setWineshop_ID(bb);
		price.setPrice_ID(xx);
		dao.update(price);
		response.sendRedirect("success1.jsp");
		
	}

}
