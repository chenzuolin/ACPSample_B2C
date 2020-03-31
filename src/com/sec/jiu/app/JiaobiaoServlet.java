package com.sec.jiu.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.Wineshop;

/**
 * Servlet implementation class JiaobiaoServlet
 */
@WebServlet("/JiaobiaoServlet")
public class JiaobiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiaobiaoServlet() {
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
		response.setContentType("text/html,charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		int indent_id = Integer.parseInt(request.getParameter("indent_id"));
		String wineshop_username = request.getParameter("username");
		WineshopDao dao = new WineshopDao();
		List<Wineshop> list = dao.Select(wineshop_username);
		Indent indent = new Indent();
		IndentDao cc = new IndentDao();
		for (Wineshop wineshop : list) {
			int Wineshop_id = wineshop.getWineshop_ID();
			indent.setIndent_Check_Type("1");
			indent.setIndent_ID(indent_id);
			indent.setWineshop_ID(Wineshop_id);
			cc.update3(indent);
		}
		
		
		
	}

}
