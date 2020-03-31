package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class SSS1ervlet
 */
@WebServlet("/SSS1ervlet")
public class SSS1ervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSS1ervlet() {
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
		String aa = request.getParameter("d");
		GreensDao dao = new GreensDao();
		if(aa.contains("È«²¿")) {
			List<Greens> list = dao.findAll();
			request.setAttribute("list", list);
			request.getSession().setAttribute("aa", aa);
			request.getRequestDispatcher("S1.jsp").forward(request, response);
		}else {
		List<Greens> list = dao.findUserByTY(aa);
		request.setAttribute("list",list);
		request.getSession().setAttribute("aa", aa);
		request.getRequestDispatcher("S1.jsp").forward(request, response);
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
