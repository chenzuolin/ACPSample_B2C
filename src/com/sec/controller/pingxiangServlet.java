package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_ConditionDao;
import com.sec.dao.Greens_UnitDao;
import com.sec.entity.Greens_Condition;
import com.sec.entity.Greens_Unit;

/**
 * Servlet implementation class pingxiangServlet
 */
@WebServlet("/pingxiangServlet")
public class pingxiangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pingxiangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pingxiang = request.getParameter("pingxiang");
		Greens_Condition greens_Condition = new Greens_Condition();
		Greens_ConditionDao dao = new Greens_ConditionDao();
		greens_Condition.setGreens_Condition(pingxiang);
		dao.add(greens_Condition);
		response.sendRedirect("pingxiang.jsp");
	}

}
