package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_ConditionDao;
import com.sec.dao.Greens_TypeDao;
import com.sec.entity.Greens_Condition;
import com.sec.entity.Greens_Type;

/**
 * Servlet implementation class leixinservlet
 */
@WebServlet("/leixinServlet")
public class leixinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leixinServlet() {
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
		String leixin = request.getParameter("name");
		String bigType = request.getParameter("bigName");
		Greens_Type tt = new Greens_Type();
		tt.setGreens_Type_Name(leixin);
		tt.setGreens_BigTypeName(bigType);
		Greens_TypeDao dao = new Greens_TypeDao();
		dao.add(tt);
	}

}
