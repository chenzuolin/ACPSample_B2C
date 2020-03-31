package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_NormsDao;
import com.sec.dao.Greens_UnitDao;
import com.sec.entity.Greens_Norms;
import com.sec.entity.Greens_Unit;

/**
 * Servlet implementation class guigeServlet
 */
@WebServlet("/guigeServlet")
public class guigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guigeServlet() {
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
		String guige = request.getParameter("guige");
		Greens_Norms greens_Norms = new Greens_Norms();
		Greens_NormsDao dao = new Greens_NormsDao();
		greens_Norms.setGreens_Norms(guige);
		dao.add(greens_Norms);
		response.sendRedirect("guige.jsp");
	}

}
