package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Fare_PriceDao;
import com.sec.entity.Fare_Price;

/**
 * Servlet implementation class FareServlet
 */
@WebServlet("/FareServlet")
public class FareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FareServlet() {
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
		float aa = Float.parseFloat(request.getParameter("b1"));
		float bb = Float.parseFloat(request.getParameter("b2"));
		float cc = Float.parseFloat(request.getParameter("b3"));
		float dd = Float.parseFloat(request.getParameter("b4"));
		float ee = Float.parseFloat(request.getParameter("b5"));
		float ff = Float.parseFloat(request.getParameter("b6"));
		float gg = Float.parseFloat(request.getParameter("b7"));
		Fare_PriceDao dao = new Fare_PriceDao();
		Fare_Price fare_Price = new Fare_Price();
		fare_Price.setAa(aa);
		fare_Price.setBb(bb);
		fare_Price.setCc(cc);
		fare_Price.setDd(dd);
		fare_Price.setEe(ee);
		fare_Price.setFf(ff);
		fare_Price.setGg(gg);
		fare_Price.setFare_Price_ID(1);
		dao.update(fare_Price);
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('更新成功');window.location.href='Fare.html'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
