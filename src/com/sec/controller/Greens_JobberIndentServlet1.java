package com.sec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.entity.Indent;

/**
 * Servlet implementation class Greens_JobberIndentServlet1
 */
@WebServlet("/Greens_JobberIndentServlet1")
public class Greens_JobberIndentServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Greens_JobberIndentServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String a = request.getParameter("Indent_Status");
		request.getSession().setAttribute("a", a);
		String c = request.getParameter("Greens_characteristics");
		String b = request.getParameter("Greens_characteristics1");
		System.out.println(c);
		System.out.println(b);
		IndentDao dao = new IndentDao();
		List<Indent> list = dao.findUserByID5(c, b);
		request.getSession().setAttribute("c", c);
		request.getSession().setAttribute("b", b);
		
		System.out.println(list);
		request.setAttribute("list", list);
		if(a.contains("正在处理")) {
			request.getRequestDispatcher("UserControllers1").forward(request, response);
		}else {
			if(a.contains("正在分拣")) {
				request.getRequestDispatcher("UserControllers2").forward(request, response);
			}else {
				if(a.contains("配送中")) {
				request.getRequestDispatcher("UserControllers3").forward(request, response);
				}else {
					if(a.contains("已完成")) {
						request.getRequestDispatcher("UserControllers4").forward(request, response);
					}else {
						request.getRequestDispatcher("UserControllers5").forward(request, response);
					}
				}
			}
		}
	}

}
