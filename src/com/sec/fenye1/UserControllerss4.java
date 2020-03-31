package com.sec.fenye1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserControllerss4
 */
@WebServlet("/UserControllerss4")
public class UserControllerss4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IndentService1 indents = new IndentService1();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerss4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String currentPage =request.getParameter("currentPage");
		
		String ggg = request.getParameter("s1");
		System.out.println(ggg);
		String aaa = "«Î—°‘Ò";
		request.getSession().setAttribute("aa", aaa);
		
		//System.out.println(currentPage);
		Page1 page =null;
		try {
			page =indents.pageUsers3(currentPage,ggg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		System.out.println(page.getshowuser());
		request.setAttribute("page", page);	
		request.getRequestDispatcher("S1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
