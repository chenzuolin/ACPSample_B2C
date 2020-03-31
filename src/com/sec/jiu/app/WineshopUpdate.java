package com.sec.jiu.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.WineshopDao;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class WineshopUpdate
 */
@WebServlet("/WineshopUpdate")
public class WineshopUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WineshopUpdate() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String name = request.getParameter("name");
		String timeMin = request.getParameter("timeMin");
		String timeMax = request.getParameter("timeMax");
		Wineshop cc = new Wineshop();
		cc.setWineshop_Time(timeMin);
		cc.setWineshop_TimeNight(timeMax);
		cc.setWineshop_Name(name);
		WineshopDao dao = new WineshopDao();
		int updateTime = dao.updateTime(cc);
		PrintWriter writer = response.getWriter();
		writer.print(updateTime);
		writer.flush();
		writer.close();
	}

}
