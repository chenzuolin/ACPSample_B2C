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
 * Servlet implementation class quanxianServlet
 */
@WebServlet("/quanxianServlet")
public class quanxianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanxianServlet() {
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
		int aa = (Integer)request.getSession().getAttribute("w");//User_ID
		User_PermissionDao dao = new User_PermissionDao();
		int bb = dao.findUserByID3(aa);//权限编号
		PermissionDao dao1 = new PermissionDao();
		String cc = dao1.findUserByID(bb);
		if(cc.contains("超级管理员")) {
			response.sendRedirect("QX.jsp");
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
