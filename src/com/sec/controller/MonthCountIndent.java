package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sumeng.service.MonthCount;
import com.sumeng.web.IndentDao;

/**
 * Servlet implementation class MonthCountIndent
 */
@WebServlet("/MonthCountIndent")
public class MonthCountIndent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthCountIndent() {
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
		IndentDao dao = new IndentDao();
		List<MonthCount> monthCountIndent = dao.monthCountIndent();
		JSONArray json = JSONArray.fromObject(monthCountIndent);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
