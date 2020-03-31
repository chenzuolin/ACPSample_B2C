package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.dao.GreensDao;
import com.sec.entity.Greens;
import com.sumeng.page.Page;

/**
 * Servlet implementation class FindByGreensNameLike
 */
@WebServlet("/FindByGreensNameLike")
public class FindByGreensNameLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByGreensNameLike() {
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
		String greensName = request.getParameter("name");
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
		int currPage = 1;
		if(currentPage != null) {
			currPage = Integer.parseInt(currentPage);
		}
		GreensDao dao = new GreensDao();
		Page pa =  dao.getSumCount(currPage, size, greensName);
		Page page = dao.getSunData(currPage, pa, size, greensName);
		Object json = JSON.toJSON(page);
		response.getWriter().print(json);
	}

}
