package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.IndentDao;
import com.sec.dao.OrderDao;
import com.sec.entity.Indent;
import com.sec.entity.Order;

/**
 * Servlet implementation class GreensJobberIndexServlet1
 */
@WebServlet("/GreensJobberIndexServlet1")
public class GreensJobberIndexServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreensJobberIndexServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int yy = Integer.parseInt(request.getParameter("id"));
		//int id = (Integer)request.getSession().getAttribute("Indent");
		System.out.println(yy);
		IndentDao dao = new IndentDao();
		OrderDao dao1 = new OrderDao();
		Indent indent = new Indent();
		Order order = new Order();
		indent.setIndent_Status("分拣完毕等待快递员接收");
		indent.setIndent_ID(yy);
		dao.update1(indent);
		order.setIndent_Status("分拣完毕等待快递员接收");
		order.setIndent_ID(yy);
		dao1.update1(order);
		response.sendRedirect("Greens_JobberIndent8.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
