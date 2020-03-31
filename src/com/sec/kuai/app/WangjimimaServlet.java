package com.sec.kuai.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.CourierDao;
import com.sec.entity.Courier;

/**
 * Servlet implementation class WangjimimaServlet
 */
@WebServlet("/WangjimimaServlet")
public class WangjimimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WangjimimaServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		CourierDao dao = new CourierDao();
		int Id = dao.AlterPassWord(name);
		if(Id == 0) {
			out.print(Id);
			out.flush();
			out.close();
		}else {
			Courier courier = new Courier();
			courier.setCourier_Name(name);
			courier.setCourier_Password(pwd);
			dao.update1(courier);
			out.print(2);
			out.flush();
			out.close();
		}
		
	}

}
