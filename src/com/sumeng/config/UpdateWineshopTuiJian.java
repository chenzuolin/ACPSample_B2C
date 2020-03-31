package com.sumeng.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sumeng.web.WineshopDao;

/**
 * Servlet implementation class UpdateWineshopTuiJian
 */
@WebServlet("/UpdateWineshopTuiJian")
public class UpdateWineshopTuiJian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWineshopTuiJian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String username = request.getParameter("username");
		String wineshopTuiJian = request.getParameter("wineshopTuiJian");
		WineshopDao dao = new WineshopDao();
		String updateWineshopTuiJian = dao.updateWineshopTuiJian(username, wineshopTuiJian);
		if(updateWineshopTuiJian.equals("success")){
			response.getWriter().print("success");
		}
	}

}
