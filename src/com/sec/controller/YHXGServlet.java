package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.WineshopDao;
import com.sec.entity.Wineshop;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class YHXGServlet
 */
@WebServlet("/YHXGServlet")
public class YHXGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YHXGServlet() {
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
		int c = Integer.parseInt(request.getParameter("id"));
		String a = request.getParameter("password");
		String b = request.getParameter("cellphone");
		WineshopDao dao = new WineshopDao();
		Wineshop wineshop = new Wineshop();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		wineshop.setWineshop_Password(a);
		//wineshop.setWineshop_Telephone(b);
		wineshop.setWineshop_ID(c);
		int lll = dao.update5(wineshop);
		PrintWriter out = response.getWriter();
		out.print(lll);
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
