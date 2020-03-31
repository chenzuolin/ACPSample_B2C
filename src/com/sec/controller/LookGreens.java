package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.GreensDao;
import com.sec.entity.Greens;

/**
 * Servlet implementation class LookGreens
 */
@WebServlet("/LookGreens")
public class LookGreens extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookGreens() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		GreensDao dao = new GreensDao();
		Greens green = dao.findObjectByID(id);
		request.setAttribute("obj", green);
		request.getRequestDispatcher("./admin/greens/look.jsp").forward(request, response);
	}

}
