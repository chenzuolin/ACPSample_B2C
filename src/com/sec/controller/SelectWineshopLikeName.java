package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.entity.Wineshop;
import com.sumeng.web.WineshopDao;

/**
 * Servlet implementation class SelectWineshopLikeName
 */
@WebServlet("/SelectWineshopLikeName")
public class SelectWineshopLikeName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectWineshopLikeName() {
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
		String name = request.getParameter("id");
		WineshopDao dao = new WineshopDao();
		List<Wineshop> findAllName = dao.findAllLikeListName(name);
		if(findAllName.isEmpty()){
			PrintWriter out = response.getWriter();
			out.print("<script langage='javascript'>alert('您输入的酒店名称不存在，请重新输入！！！');window.location.href='findAllWineshop.jsp'</script>");
			
		}else{
			request.setAttribute("f", findAllName);
			request.getRequestDispatcher("wineshopNameLike.jsp").forward(request, response);
		}
	}

}
