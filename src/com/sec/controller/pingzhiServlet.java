package com.sec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_CharacterDao;
import com.sec.entity.Greens_Character;

/**
 * Servlet implementation class pingzhiServlet
 */
@WebServlet("/pingzhiServlet")
public class pingzhiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pingzhiServlet() {
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
		String pingzhi = request.getParameter("pingzhi");
		Greens_Character greens_Character = new Greens_Character();
		Greens_CharacterDao dao = new Greens_CharacterDao();
		greens_Character.setGreens_Character(pingzhi);
		dao.add(greens_Character);
		response.sendRedirect("pingzhi.jsp");
		
	}

}
