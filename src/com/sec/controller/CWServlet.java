package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.PermissionDao;
import com.sec.dao.User_PermissionDao;

/**
 * Servlet implementation class CWServlet
 */
@WebServlet("/CWServlet")
public class CWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CWServlet() {
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
		int aa = (Integer)request.getSession().getAttribute("w");//管理员登陆
		User_PermissionDao dao = new User_PermissionDao();
		int bb = dao.findUserByID3(aa);
		PermissionDao dao1 = new PermissionDao();
		String cc = dao1.findUserByID(bb);
		System.out.println(cc);
		if(cc.contains("财务")) {
			response.sendRedirect("CW.jsp");
		}else {
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('您没有该权限哦！！');</script>");
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
