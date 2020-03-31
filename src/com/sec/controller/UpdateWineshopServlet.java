package com.sec.controller;

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
 * Servlet implementation class UpdateWineshopServlet
 */
@WebServlet("/UpdateWineshopServlet")
public class UpdateWineshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWineshopServlet() {
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
		
		String wineshop_UserName = request.getParameter("wineshop_UserName");
		String wineshop_Password = request.getParameter("wineshop_Password");
		String wineshop_Name = request.getParameter("wineshop_Name");
		String wineshop_Shift_Name = request.getParameter("wineshop_Shift_Name");
		String wineshop_Telephone = request.getParameter("wineshop_Telephone");
		String wineshop_Nature = request.getParameter("wineshop_Nature");
		String wineshop_QQ = request.getParameter("wineshop_QQ");
		String wineshop_WeChat = request.getParameter("wineshop_WeChat");
		String wineshop_Number = request.getParameter("wineshop_Number");
		String wineshop_Time = request.getParameter("wineshop_Time");
		String wineshop_TimeNight = request.getParameter("wineshop_TimeNight");
		String wineshop_TuiJian = request.getParameter("wineshop_TuiJian");
		String wineshop_ID = request.getParameter("wineshop_ID");
		String wineshop_addr = request.getParameter("addr");
		int ID = Integer.parseInt(wineshop_ID);
		
		
		Wineshop cc = new Wineshop();
		cc.setWineshop_UserName(wineshop_UserName);
		cc.setWineshop_Password(wineshop_Password);
		cc.setWineshop_Name(wineshop_Name);
		cc.setWineshop_Shift_Name(wineshop_Shift_Name);
		cc.setWineshop_Telephone(wineshop_Telephone);
		cc.setWineshop_Nature(wineshop_Nature);
		cc.setWineshop_QQ(wineshop_QQ);
		cc.setWineshop_WeChat(wineshop_WeChat);
		cc.setWineshop_Number(wineshop_Number);
		cc.setWineshop_Time(wineshop_Time);
		cc.setWineshop_TimeNight(wineshop_TimeNight);
		cc.setWineshop_TuiJian(wineshop_TuiJian);
		cc.setWineshop_addr(wineshop_addr);
		cc.setWineshop_ID(ID);
		
		WineshopDao dao = new WineshopDao();
		dao.updateAll(cc);
		PrintWriter out = response.getWriter();
		out.print("<script langage='javascript'>alert('修改成功了哦！！');window.location.href='findAllWineshop.jsp'</script>");
	}

}
