package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.FenPeiDao;
import com.sec.entity.FenPei;

/**
 * Servlet implementation class WCFenPeiServlet
 */
@WebServlet("/WCFenPeiServlet")
public class WCFenPeiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WCFenPeiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int Wineshop_ID=Integer.parseInt(request.getParameter("wineshop_ID"));
		String Wineshop_Name = request.getParameter("wineshop_Name");
		String FenPei_UserName = request.getParameter("fenpei_UserName");
		String FenPei_Password = request.getParameter("fenpei_Password");
		String FenPei_Telephone = request.getParameter("fenpei_Telephone");
		
		FenPei fenpei = new FenPei();
		FenPeiDao dao = new FenPeiDao();
		fenpei.setWineshop_ID(Wineshop_ID);
		fenpei.setWineshop_Name(Wineshop_Name);
		fenpei.setFenPei_UserName(FenPei_UserName);
		fenpei.setFenPei_Password(FenPei_Password);
		fenpei.setFenPei_Telephone(FenPei_Telephone);
		dao.add(fenpei);
		PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('∑÷≈‰≥…π¶');window.location.href='WCFenPei.jsp'</script>");
		
		
	}

}
