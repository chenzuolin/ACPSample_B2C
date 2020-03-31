package com.sec.fenye;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserControllers7
 */
@WebServlet("/UserControllers7")
public class UserControllers7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IndentService indents = new IndentService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllers7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPage =req.getParameter("currentPage");
		req.getSession().setAttribute("currentPage", currentPage);
		Page page =null;
		try {
		
			page =indents.pageUsers21(currentPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
		req.setAttribute("page", page);	
		req.getRequestDispatcher("Greens_JobberIndent4.jsp").forward(req, resp);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
