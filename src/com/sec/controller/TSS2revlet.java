package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.UserDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.User;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class TSS2revlet
 */
@WebServlet("/TSS2revlet")
public class TSS2revlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TSS2revlet() {
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
		String a = request.getParameter("password");
		String b = request.getParameter("cellphone");
		int c = (Integer)request.getSession().getAttribute("w");
		UserDao dao = new UserDao();
		User user = new User();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		user.setUser_Password(a);
		user.setUser_ID(c);
		dao.update5(user);
		request.getRequestDispatcher("userinfo3.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
