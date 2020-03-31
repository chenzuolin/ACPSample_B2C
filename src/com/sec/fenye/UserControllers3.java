package com.sec.fenye;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserControllers3")
public class UserControllers3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IndentService indents = new IndentService();
	
	  public UserControllers3() {
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
		try {
		
			page =indents.pageUsers12(currentPage,a,b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		req.setAttribute("page", page);	
		req.getRequestDispatcher("GreensIndent.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
