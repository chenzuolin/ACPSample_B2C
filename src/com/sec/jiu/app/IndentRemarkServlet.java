package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.entity.Indent;

/**
 * Servlet implementation class IndentRemarkServlet
 */
@WebServlet("/IndentRemarkServlet")
public class IndentRemarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndentRemarkServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		int Indent_ID = Integer.parseInt(request.getParameter("Indent_ID"));
		String Indent_remark = request.getParameter("Indent_remark");
		IndentDao dao = new IndentDao();
		Indent indent = new Indent();
		//String Indent_remark = dao.Select(Indent_ID);
		indent.setIndent_remark(Indent_remark);
		indent.setIndent_ID(Indent_ID);
		dao.update99(indent);
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
