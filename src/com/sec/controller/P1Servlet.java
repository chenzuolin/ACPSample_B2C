package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class P1Servlet
 */
@WebServlet("/P1Servlet")
public class P1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P1Servlet() {
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
		String aa = request.getParameter("a");//¾ÆµêÃû³Æ
		String bb = request.getParameter("b");//Êß²ËÃû³Æ
		WineshopDao dao = new WineshopDao();
		int cc = dao.findUserByID2(aa);
		request.getSession().setAttribute("zz", aa);
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByID10(cc);
		request.getSession().setAttribute("bb", bb);
		request.setAttribute("list", list);
		request.getRequestDispatcher("P2.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
