package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_JobberDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Greens_Jobber;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class TSS1revlet
 */
@WebServlet("/TSS1revlet")
public class TSS1revlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TSS1revlet() {
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
		String a = request.getParameter("password");
		String b = request.getParameter("cellphone");
		int c = (Integer)request.getSession().getAttribute("a");
		Greens_JobberDao dao = new Greens_JobberDao();
		Greens_Jobber green = new Greens_Jobber();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		green.setGreens_Jobber_Password(a);
		green.setGreens_Jobber_ID(c);
		dao.update5(green);
		request.getRequestDispatcher("uerinfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
