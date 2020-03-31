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

/**
 * Servlet implementation class KK6Servlet
 */
@WebServlet("/KK6Servlet")
public class KK6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KK6Servlet() {
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
		String aa = request.getParameter("name");//Êß²ËÃû³Æ
		String bb = request.getParameter("id");//¾ÆµêÃû³Æ
		WineshopDao dao1 = new WineshopDao();
		int cc = dao1.findUserByID2(bb);
		GreensDao dao2 = new GreensDao();
		int dd = dao2.findUserByID2(aa);
		CartDao dao = new CartDao();
		int ee = dao.findUserByID1(cc, dd);
		dao.delete(ee);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
	}

}
