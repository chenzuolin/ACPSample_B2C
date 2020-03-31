package com.sec.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gexin.fastjson.JSON;
import com.sumeng.web.SbDao;

/**
 * Servlet implementation class SbMoney
 */
@WebServlet("/getSbMoney")
public class SbMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SbMoney() {
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
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
		int currPage=1;
		if(currentPage!=null) {
			currPage = Integer.parseInt(currentPage);
		}
		SbDao d = new SbDao();
		Map<String, Object> queryAll = d.queryAll(currPage, size);
		Object json = JSON.toJSON(queryAll);
		response.getWriter().print(json);
	}

}
