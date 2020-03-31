package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sec.dao.GreensDao;
import com.sumeng.page.Page;

/**
 * Servlet implementation class FindAllGreens
 */
@WebServlet("/FindAllGreens")
public class FindAllGreens extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllGreens() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
		int currPage = 1;
		if(currentPage != null) {
			currPage = Integer.parseInt(currentPage);
		}
		GreensDao dao = new GreensDao();
		Page p = dao.getSum(currPage,size);
		Page page = dao.getSun(currPage, p,size);
		Object json2 = JSON.toJSON(page);
		PrintWriter out = response.getWriter();
		out.print(json2);
		out.flush();
		out.close();
	}

}
