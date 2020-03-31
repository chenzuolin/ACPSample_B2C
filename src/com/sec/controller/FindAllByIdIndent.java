package com.sec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.OrderDao;
import com.sec.entity.Order;
import com.sumeng.service.AllIndent;
import com.sumeng.web.IndentDao;

/**
 * Servlet implementation class FindAllByIdIndent
 */
@WebServlet("/FindAllByIdIndent")
public class FindAllByIdIndent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllByIdIndent() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0){
			PrintWriter out = response.getWriter();
			out.print("<script langage='javascript'>alert('请输入的订单编号！！！');window.location.href='findAllIndent.jsp'</script>");
		}
		IndentDao dao = new IndentDao();
		List<AllIndent> findAllIndent = dao.findAllListIndent(id);
		if(findAllIndent.isEmpty()){
			PrintWriter out = response.getWriter();
			out.print("<script langage='javascript'>alert('您输入的订单编号不存在，请重新输入！！！');window.location.href='findAllIndent.jsp'</script>");
		}else{
			OrderDao or = new OrderDao();
			List<Order> green = or.findUserByID1(id);
			request.setAttribute("IndentAll", findAllIndent);
			request.setAttribute("g", green);
			request.getRequestDispatcher("IndentEdit.jsp").forward(request, response);
		}
		
	}

}
