package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CourierDao;
import com.sec.entity.Courier;

/**
 * Servlet implementation class KDYServlet
 */	
@WebServlet("/KDYServlet")
public class KDYServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KDYServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String tel = request.getParameter("tel");
		String type = request.getParameter("type");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CourierDao dao = new CourierDao();
		Courier zz = new Courier();
		zz.setCourier_Password(pwd);
		zz.setCourier_Name(username);
		zz.setCourier_Telephone(tel);
		zz.setCourier_Time(df.format(new Date()));
		zz.setRegionality_ID(3);
		zz.setCourier_Vehicle(type);
		dao.add(zz);
	}

}
