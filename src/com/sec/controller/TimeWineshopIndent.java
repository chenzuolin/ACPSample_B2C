package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sumeng.page.Page;
import com.sumeng.web.WineshopDao;

/**
 * Servlet implementation class TimeWineshopIndent
 */
@WebServlet("/TimeWineshopIndent")
public class TimeWineshopIndent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeWineshopIndent() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		int id = (int)request.getSession().getAttribute("id");
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		int currPage = 1;
		if(currentPage != null) {
			currPage = Integer.parseInt(currentPage);
		}
		WineshopDao dao = new WineshopDao();
		Page page = dao.findTimeIndent(id, currPage, size, startTime, endTime);
		Object json = JSON.toJSON(page);
		response.getWriter().print(json);
	}

}
