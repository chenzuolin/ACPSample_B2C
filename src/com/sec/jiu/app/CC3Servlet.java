package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.dao.GreensDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;

/**
 * Servlet implementation class CC3Servlet
 */
@WebServlet("/CC3Servlet")
public class CC3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CC3Servlet() {
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
		String aa = request.getParameter("id");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		String cc = request.getParameter("name");
		GreensDao dao1 = new GreensDao();
		int dd = dao1.findUserByID2(cc);
		int ee = Integer.parseInt(request.getParameter("num"));
		CartDao dao3 = new CartDao();
		Cart cart = new Cart();
		cart.setWineshop_ID(bb);
		cart.setGreens_ID(dd);
		cart.setNumber(ee);
		dao3.add(cart);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
