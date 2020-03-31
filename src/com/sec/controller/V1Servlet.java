package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.DynamicDao;
import com.sec.dao.GreensDao;
import com.sec.entity.Dynamic;

/**
 * Servlet implementation class V1Servlet
 */
@WebServlet("/V1Servlet")
public class V1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V1Servlet() {
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
		String aa = request.getParameter("a");//Êß²ËÃû³Æ
		System.out.println(aa);
		GreensDao dao = new GreensDao();
		int bb = dao.findUserByID2(aa);//Êß²Ë±àºÅ
		DynamicDao dao1 = new DynamicDao();
		List<Dynamic> list = dao1.findUserByIDweekone(bb);
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("V2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
