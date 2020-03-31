package com.sec.fenye1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserControllerss1
 */
@WebServlet("/UserControllerss1")
public class UserControllerss1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	IndentService1 indents = new IndentService1();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerss1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPage =request.getParameter("currentPage");
		
		String jjj = request.getParameter("d");
		if(jjj.contains("È«²¿")) {
			request.getSession().setAttribute("aa", jjj);
			
			//System.out.println(currentPage);
			Page1 page =null;
			try {
				page =indents.pageUsers(currentPage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	
			System.out.println(page.getshowuser());
			request.setAttribute("page", page);	
			request.getRequestDispatcher("S1.jsp").forward(request, response);
		}else {
		request.getSession().setAttribute("aa", jjj);
		
		//System.out.println(currentPage);
		Page1 page =null;
		try {
			page =indents.pageUsers2(currentPage,jjj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		System.out.println(page.getshowuser());
		request.setAttribute("page", page);	
		request.getRequestDispatcher("S1.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
