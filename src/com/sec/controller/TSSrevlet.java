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

import com.sec.dao.ComplainantDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Complainant;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class TSSrevlet
 */
@WebServlet("/TSSrevlet")
public class TSSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TSSrevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String a = request.getParameter("password");
		String b = request.getParameter("cellphone");
		int c = (Integer)request.getSession().getAttribute("id");
		WineshopDao dao = new WineshopDao();
		Wineshop wineshop = new Wineshop();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		wineshop.setWineshop_Password(a);
		//wineshop.setWineshop_Telephone(b);
		wineshop.setWineshop_ID(c);
		dao.update5(wineshop);
		request.getRequestDispatcher("userinfo2.jsp").forward(request, response);
		/*System.out.println(Complainant_Content);
		System.out.println(Complainant_Type);
		System.out.println(df.format(new Date()));
		System.out.println(Wineshop_ID);*/

	}

}
