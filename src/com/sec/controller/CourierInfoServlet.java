package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CourierDao;
import com.sec.dao.IndentDao;
import com.sec.entity.Courier;
import com.sec.entity.Indent;

/**
 * Servlet implementation class CourierInfoServlet
 */
@WebServlet("/CourierInfoServlet")
public class CourierInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourierInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourierDao a = new CourierDao();
		IndentDao b = new IndentDao();
		List<Courier> list=a.findAll();
		//for(Courier courier:list){
			//System.out.println(courier.getCourier_ID());
			//System.out.println(courier.getCourier_Name());
		
		
		List<Indent> lis=b.findAll();
		//for(Indent intent : lis){
		request.setAttribute("list", list);
		request.setAttribute("lis", lis);
		//System.out.println(list);
		//System.out.println(lis);           
		request.getRequestDispatcher("CourierInfo.jsp").forward(request, response);
		
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
