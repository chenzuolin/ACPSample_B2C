package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.sec.dao.Greens_JobberDao;
import com.sec.dao.WineshopDao;

/**
 * Servlet implementation class Greens_JobberServlet
 */
@WebServlet("/Greens_JobberServlet")
public class Greens_JobberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greens_JobberServlet() {
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
			Greens_JobberDao dao = new Greens_JobberDao();
			String userName=request.getParameter("userName");
			String password = request.getParameter("password");
			int b = dao.checkGreen_Jobber(userName, password); 
				if(b != 0){
					request.getSession().setAttribute("id", b);
					response.sendRedirect("Greensindex.jsp");
				}
				else{
					PrintWriter out = response.getWriter();
					out.print("<script langage='javascript'>alert('用户名或密码错误！！');window.location.href='login1.jsp'</script>");
			}
	}
}
