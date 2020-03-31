package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.UappDao;
import com.sec.entity.Uapp;

/**
 * Servlet implementation class UpdateAppleServlet
 */
@WebServlet("/UpdateAppleServlet")
public class UpdateAppleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAppleServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uname = request.getParameter("uname");
		UappDao dao = new UappDao();
		Uapp app = new Uapp();
		app.setUtype("1");
		app.setUname(uname);
		dao.updateUname(app);
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('更新成功！！');window.location.href='./admin/seting/log.jsp'</script>");
	}

}
