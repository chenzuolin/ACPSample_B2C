package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FedbackDao;
import com.sec.entity.Fedback;

/**
 * Servlet implementation class HFFKServlet
 */
@WebServlet("/HFFKServlet")
public class HFFKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HFFKServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		int Wineshop_ID = Integer.parseInt(request.getParameter("id"));
		String Fedback_Content = request.getParameter("Fedback_Content");
		FedbackDao dao = new FedbackDao();
		Fedback fedback = new Fedback();
		fedback.setFedback_Content(Fedback_Content);
		fedback.setWineshop_ID(Wineshop_ID);
		fedback.setFedback_Time(df.format(new Date()));
		dao.add(fedback);
		/*System.out.println(Fedback_Content);
		System.out.println(Wineshop_ID);
		System.out.println(df.format(new Date()));*/
		
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('回复成功');</script>");
		
		
	}

}
