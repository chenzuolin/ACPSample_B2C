package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.UserDao;
import com.sec.entity.User;

/**
 * Servlet implementation class HHServlet
 */
@WebServlet("/HHServlet")
public class HHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HHServlet() {
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
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		UserDao dao = new UserDao();
		User user = new User();
		user.setUser_Name(a);
		user.setUser_Password(b);
		user.setRole_ID(4);
		user.setDepartment_ID(1);
		dao.add(user);
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('Ìí¼Ó³É¹¦');window.location.href='HH.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
