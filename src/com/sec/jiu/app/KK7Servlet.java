package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.PriceDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Price;

/**
 * Servlet implementation class KK7Servlet
 */
@WebServlet("/KK7Servlet")
public class KK7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KK7Servlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");	
		String aa = request.getParameter("username");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		PriceDao dao1 = new PriceDao();
		List<Price> list = dao1.findUserByID2(bb);
		for(Price price : list){
			Float cc = price.getPrice_num();
			float dd = (float)(Math.round(cc*100))/100;
			PrintWriter out = response.getWriter();
			out.print(dd);
			out.flush();
			out.close();
	}
	}

}
