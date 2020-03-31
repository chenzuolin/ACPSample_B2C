package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CourierDao;
import com.sec.dao.Courier_WineshopDao;
import com.sec.entity.Courier;
import com.sec.entity.Courier_Wineshop;

/**
 * Servlet implementation class Fenpei1Servlet
 */
@WebServlet("/Fenpei1Servlet")
public class Fenpei1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fenpei1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.print(id);
		
		CourierDao Dao1=new CourierDao();
		List<Courier> list1=Dao1.findUserByID2(id);
		System.out.println(list1);
		Courier_WineshopDao dao=new Courier_WineshopDao();
		List<Courier_Wineshop> list=dao.findUserByID(id);
		System.out.println(list);
		request.setAttribute("list1", list1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("fenpei2.jsp").forward(request, response);
		
	}

}
