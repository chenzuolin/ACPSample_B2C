package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.TotalDao;
import com.sec.dao.WineshopDao;
import com.sec.entity.Indent;
import com.sec.entity.Total;

/**
 * Servlet implementation class T3Servlet
 */
@WebServlet("/T3Servlet")
public class T3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String aa = request.getParameter("Greens_Unit");//酒店名称
		//System.out.println(aa);
		WineshopDao dao = new WineshopDao();
		int bb = dao.findUserByID3(aa);//酒店ID
		request.getSession().setAttribute("bb", bb);
		//System.out.println(bb);
		IndentDao dao1 = new IndentDao();
		List<Indent> list = dao1.findUserByID0();
		request.setAttribute("list", list);
		/*System.out.println(list);
		for(Indent indent : list) {
			int zz = indent.getWineshop_ID();
			//System.out.println(zz);
			if(zz==bb) {
				int xx = indent.getIndent_ID();
				TotalDao dao2 = new TotalDao();
				List<Total> list1 = dao2.findUserByID1(xx);
				request.setAttribute("list1", list1);
			}else {
				PrintWriter out = response.getWriter();
				out.print("<script langage='javascript'>alert('没有数据！');</script>");
			}
		}*/
		request.getRequestDispatcher("T4.jsp").forward(request, response);
	}

}
