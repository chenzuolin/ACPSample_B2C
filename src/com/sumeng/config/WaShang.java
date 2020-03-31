package com.sumeng.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sumeng.web.WineshopDao;

/**
 * Servlet implementation class WaShang
 */
@WebServlet("/WaShang")
public class WaShang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaShang() {
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
		String username = request.getParameter("user");
		String name = request.getParameter("name");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String tuijian = request.getParameter("tuijian");
		WineshopDao dao = new WineshopDao();
		String wangshang = dao.wangshang(name, addr, tel, time1, time2, tuijian, username);
		if(wangshang.equals("success")){
			response.getWriter().print("success");
		}
	}

}
