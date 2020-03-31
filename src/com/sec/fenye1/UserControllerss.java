package com.sec.fenye1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserControllerss")
public class UserControllerss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IndentService1 indents = new IndentService1();
	
	  public UserControllerss() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String currentPage =req.getParameter("currentPage");
		System.out.println(currentPage);
		req.getSession().setAttribute("currentPage", currentPage);
		Page1 page =null;
		try {
		
			page =indents.pageUsers1(currentPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		System.out.println(page.getshowuser());
		req.setAttribute("page", page);	
		req.getRequestDispatcher("WineshopList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
