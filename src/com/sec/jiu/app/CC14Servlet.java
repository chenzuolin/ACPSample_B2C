package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CartDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Cart;

/**
 * Servlet implementation class CC14Servlet
 */
@WebServlet("/CC14Servlet")
public class CC14Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CC14Servlet() {
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
		String aa = request.getParameter("name");
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID2(aa);
		int cc = Integer.parseInt(request.getParameter("greens_ID"));
		int dd = Integer.parseInt(request.getParameter("number"));
		CartDao dao1 = new CartDao();
		Cart cart = new Cart();
		cart.setWineshop_ID(bb);
		cart.setGreens_ID(cc);
		cart.setNumber(dd);
		dao1.add(cart);
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
		doGet(request, response);
	}

}
