package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.entity.FindAllGreens;

/**
 * Servlet implementation class UpdateGreens
 */
@WebServlet("/UpdateGreens")
public class UpdateGreens extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGreens() {
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
		int ID = Integer.parseInt(request.getParameter("ID"));
		float price = Float.parseFloat(request.getParameter("price"));
		float market = Float.parseFloat(request.getParameter("market"));
		
		GreensDao dao = new GreensDao();
		FindAllGreens g = new FindAllGreens();
		g.setGreens_Price(price);
		g.setGreens_Market_Price(market);
		g.setGreens_ID(ID);
		dao.update1001(g);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
