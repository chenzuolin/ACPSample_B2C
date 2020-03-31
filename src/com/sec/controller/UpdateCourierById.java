package com.sec.controller;

import java.io.IOException;
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
 * Servlet implementation class UpdateCourierById
 */
@WebServlet("/UpdateCourierById")
public class UpdateCourierById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourierById() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String type = request.getParameter("type");
		String pwd = request.getParameter("pwd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Courier con = new Courier();
		con.setCourier_ID(id);
		con.setCourier_Name(name);
		con.setCourier_Password(pwd);
		con.setCourier_Telephone(tel);
		con.setCourier_Vehicle(type);
		con.setCourier_Time(sdf.format(new Date()));
		con.setRegionality_ID(3);
		CourierDao dao = new CourierDao();
		int code = dao.updateById(con);
		response.getWriter().print(code);
	}

}
