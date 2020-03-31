package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.WineshopDao;

/**
 * Servlet implementation class PPP1Servlet
 */
@WebServlet("/PPP1Servlet")
public class PPP1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PPP1Servlet() {
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
		String aa = request.getParameter("Indent_Status");
		WineshopDao dao = new 	WineshopDao();
		int bb = dao.findUserByID2(aa);
		if(bb<=0){
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('û�иþƵ�!!');window.location.href='XXTS.jsp'</script>");
			request.getRequestDispatcher("FZR.jsp").forward(request, response);
		}else{
			
		}
	}

}
