package com.sec.controller;

import java.io.IOException;
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
 * Servlet implementation class zzzServlet
 */
@WebServlet("/zzzServlet")
public class zzzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zzzServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		GreensDao dao = new GreensDao();
		int a = dao.findUserByID2(name);
		DynamicDao dao1 = new DynamicDao();
		List<Dynamic> list = dao1.findUserByID1(a);
		request.setAttribute("list", list);
		request.getRequestDispatcher("zzz1.jsp").forward(request, response);
		
	}

}
