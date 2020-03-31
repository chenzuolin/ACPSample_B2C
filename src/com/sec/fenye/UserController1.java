package com.sec.fenye;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserController1")
public class UserController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IndentService indents = new IndentService();
	
	  public UserController1() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String currentPage =req.getParameter("currentPage");
		String a = req.getSession().getAttribute("c").toString();
		String b = req.getSession().getAttribute("b").toString();
		System.out.println(currentPage);
		req.getSession().setAttribute("currentPage", currentPage);
		Page page =null;
		int xx = (Integer)req.getSession().getAttribute("id");
		try {
		
			page =indents.pageUsers2(currentPage,xx,a,b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		req.setAttribute("page", page);	
		req.getRequestDispatcher("Indent4.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
