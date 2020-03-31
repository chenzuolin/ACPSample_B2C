package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.WineshopDao;
import com.sec.entity.Page;

/**
 * Servlet implementation class WineshopTuijianServlet
 */
@WebServlet("/WineshopTuijianServlet")
public class WineshopTuijianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WineshopTuijianServlet() {
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
		String currentPage = request.getParameter("currentPage");
		int currPage = 1;
		if(currentPage != null) {
			currPage = Integer.parseInt(currentPage);
		}
		WineshopDao dao = new WineshopDao();
		Page p = dao.getSum(currPage);
		Page page = dao.getSun(currPage, p);
		request.setAttribute("page", page);
		request.getRequestDispatcher("wineshoptuijian.jsp").forward(request, response);
	}

}
