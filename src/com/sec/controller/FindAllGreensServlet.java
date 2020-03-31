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
import com.sumeng.page.fenye;


/**
 * Servlet implementation class FindAllGreensServlet
 */
@WebServlet("/FindAllGreensServlet")
public class FindAllGreensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllGreensServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String currentPage = request.getParameter("currentPage");
		int size = Integer.parseInt(request.getParameter("size"));
//		String currentPage = "1";
//		
//		int size = 5;
//		String Wineshop_Name = "666";
//		String Time1 = "2019-05-04";
//		String Time2 = "2019-05-07";
		int currPage=1;
		if(currentPage!=null) {
			currPage = Integer.parseInt(currentPage);
			
		}
		GreensDao dao = new GreensDao();
		fenye f =dao.getSum8(currPage, size);
		fenye f1 = dao.getSun8(currPage, f, size);
		Object json = JSON.toJSON(f1);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
