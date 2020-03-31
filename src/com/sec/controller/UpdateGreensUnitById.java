package com.sec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sec.dao.Greens_UnitDao;
import com.sec.entity.Greens_Unit;

/**
 * Servlet implementation class UpdateGreensUnitById
 */
@WebServlet("/UpdateGreensUnitById")
public class UpdateGreensUnitById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGreensUnitById() {
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
		request.setCharacterEncoding("utf-8");
		int parameter =Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Greens_Unit cc = new Greens_Unit();
		cc.setGreens_Unit(name);
		cc.setGreens_Unit_ID(parameter);
		Greens_UnitDao dao = new Greens_UnitDao();
		int dd = dao.updateUnitById(cc);
	}

}
