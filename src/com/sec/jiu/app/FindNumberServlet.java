package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class FindNumberServlet
 */
@WebServlet("/FindNumberServlet")
public class FindNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNumberServlet() {
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
		String Wineshop_username = request.getParameter("username");
		WineshopDao dao1 = new WineshopDao();
		String wineshop = Wineshop_username;
		List<Wineshop> select = dao1.Select(wineshop);
		int Wineshop_ID = 0;
		for (Wineshop wineshop2 : select) {
			Wineshop_ID = wineshop2.getWineshop_ID();
		}
		String dd = "0";
		String type = "正在处理";
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findNumberJiaobiao(Wineshop_ID,dd,type);
		System.out.println(list);
		PrintWriter out = response.getWriter();
		out.print(list.size());
		out.flush();
		out.close();
	}

}
