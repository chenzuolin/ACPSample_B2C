package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.entity.Uapp;
import com.sumeng.web.UappDao;

/**
 * Servlet implementation class UpdateUappConduct
 */
@WebServlet("/UpdateUappConduct")
public class UpdateUappConduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUappConduct() {
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
		int uid = Integer.parseInt(request.getParameter("id"));
		String utype = request.getParameter("valid");
		Uapp app = new Uapp();
		app.setUtype(utype);
		app.setUid(uid);
		UappDao dao = new UappDao();
		int update = dao.update(app);
		response.getWriter().print(update);
	}

}
