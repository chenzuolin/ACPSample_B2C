package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.Greens;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class Q1Servlet
 */
@WebServlet("/Q1Servlet")
public class Q1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q1Servlet() {
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
		String aa = request.getParameter("a");
		GreensDao dao = new GreensDao();
		int bb = dao.findUserByID2(aa);
		if(bb!=0) {
		request.getSession().setAttribute("bb", bb);
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByIDweek();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Q2.jsp").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script langage='javascript'>alert('√ª”–∏√ ﬂ≤À≈∂£°');</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
