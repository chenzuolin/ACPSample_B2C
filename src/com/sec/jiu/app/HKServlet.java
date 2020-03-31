package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.PriceDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Price;

/**
 * Servlet implementation class HKServlet
 */
@WebServlet("/HKServlet")
public class HKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HKServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String Wineshop_UserName = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int Wineshop_ID  = dao.findUserByID2(Wineshop_UserName);
		PriceDao dao1 = new PriceDao();
		Price price = new Price();
		price.setPrice_num(0);
		price.setWineshop_ID(Wineshop_ID);
		dao1.update88(price);
		PrintWriter out = response.getWriter();
		out.println(1);
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
