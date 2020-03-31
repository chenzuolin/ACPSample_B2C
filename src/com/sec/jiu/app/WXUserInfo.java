package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sumeng.web.WineshopDao;

/**
 * Servlet implementation class WXUserInfo
 */
@WebServlet("/userinfo")
public class WXUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WXUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		WineshopDao dao = new WineshopDao();
		PrintWriter out = response.getWriter();
		String username = request.getParameter("user");
		String name = request.getParameter("name");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String tuijian = request.getParameter("tuijian");
		int checkName = dao.checkName(name);
		String checkTel = dao.checkTel(tel);
		int cc = Integer.parseInt(checkTel);
		if(checkName!=0){
			out.print(0);
			out.flush();
			out.close();
		}else if(cc!=0){
			out.print(1);
			out.flush();
			out.close();
		}else{
			String wangshang = dao.wangshang(name, addr, tel, time1, time2, tuijian, username);
			if(wangshang.equals("success")){
				out.print(2);
				out.flush();
				out.close();
			}
		}
	}

}
