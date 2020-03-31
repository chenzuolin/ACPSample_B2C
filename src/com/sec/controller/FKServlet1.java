package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.TouSuDao;
import com.sec.entity.TouSu;

/**
 * Servlet implementation class FKServlet1
 */
@WebServlet("/FKServlet1")
public class FKServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FKServlet1() {
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
		int TouSu_ID = Integer.parseInt(request.getParameter("bb"));
		
		System.out.println(TouSu_ID+"TouSu_ID");
		String FanKui_Text = request.getParameter("cc");
		System.out.println(FanKui_Text+"FanKui_Text");
		TouSuDao dao = new TouSuDao();
		TouSu tousu = new TouSu();
		tousu.setTouSu_ID(TouSu_ID);
		tousu.setFanKui_Text(FanKui_Text);
		dao.update(tousu);
		
		
		
		
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('»Ø¸´³É¹¦');window.location.href='admin/TouSu/ChakanTouSu.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
