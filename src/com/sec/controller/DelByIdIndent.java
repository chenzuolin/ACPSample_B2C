package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FZDao;
import com.sec.dao.OrderDao;
import com.sec.dao.TotalDao;
import com.sumeng.web.IndentDao;

/**
 * Servlet implementation class DelByIdIndent
 */
@WebServlet("/DelByIdIndent")
public class DelByIdIndent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelByIdIndent() {
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
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		IndentDao dao = new IndentDao();
		int delete = dao.delete(id);
		OrderDao order = new OrderDao();
		int dd = order.delIndentById(id);
		
		TotalDao tot = new TotalDao();
		int ee = tot.delIndentById(id);
		
		FZDao fz = new FZDao();
		int ff = fz.delIndentById(id);
		PrintWriter writer = response.getWriter();
		writer.print(delete);
		writer.flush();
		writer.close();
	}

}
